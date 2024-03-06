import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * OBjectDBIO 는 Board 클래스의 메소드를 모아놓은 Board_Impl 자바 파일에서 원활한 사용을 위해서 작성이 되었습니다.
 * Board_Impl 에서 extends 를 해서 해당 내용들을 사용 하시면 됩니다.
 */
public abstract class ObjectDBIO {
    public Connection conn = null;

    /**
     * DB 서버와의 연결이 성공적으로 되었는지 확인을 해주는 메소드 입니다
     * .env 파일의 정보들을 읽어와 이미 만들어둔 workbench DB 와 연결을 해주는 역활을 합니다.
     *
     * TODO::수정:: exectue 할 때 밖에 사용이 되지 않기 때문에 private 형태로 제한을 주었습니다.
     *
     * @author Tae Jin Kim
     * @date 2024-02-02
     * @return  true  : DB 서버와 연결 성공 시
     *          false : DB 서버와 연결 실패 시
     * @throws
     *          IOException            : .env 파일을 읽어오는 것을 실패 시 에러를 발생 시킵니다
     *          ClassNotFoundException : JDBC Driver 를 연결 (Class.forname()) 실패시 에러를 발생 시킵니다
     *          SQLException           : conn = DriverManager.getConnection() DB커넥션 연결 실패시 에러를 발생시킵니다
     *          Exception              : 혹시 모를 에러를 위해서 마지막에 제일 상위에 있는 Exception 을 추가를 해줍니다
     *
     */
    protected boolean open() {
        try {
            // TODO::파일경로도 .env 파일로 빼고 싶은데 .env 파일을 loading 하지 않는 한 불가능. 파일 디폴트 경로를 바꿔서 해결은 가능(?)
            FileInputStream fs = new FileInputStream("C:/Users/TaeJin Kim/shinsegae_Java_edu/Board_Team_Project/src/.env");
            Properties properties = new Properties();
            properties.load(fs);

            /**
             * 로컬 필드값에 'private String host" 식으로 해주지 않은 이유는 혹시모를 멀티스레드를 막아줍니다. (필드값을 공유하지 않음으로)
             * GitHub에 올릴때 .gitignore 파일에 .env 파일을 제외함으로서 중요한 정보가 올라가지 않기 때문에
             * 해킹이라던지 중요한 정보를 노출하지 않을 수 있습니다. 현재는 로컬에서 돌리기 때문에 상관이 없지만 추후 AWS 나 Cloud 에
             * 배포를 시킬 경우 해당 AWS 의 IP/ALB 주소나 중요한 정보들이 노출이 될 수 있기 때문에 해킹의 위험이 있기에 .env 파일을 써줬습니다.
             */
            String host = properties.getProperty("DB_HOST");
            String port = properties.getProperty("DB_PORT");
            String db = properties.getProperty("DATABASE");
            String jdbc_url = properties.getProperty("JDBC_URL");
            String username = properties.getProperty("USER");
            String pw = properties.getProperty("PASSWORD");
            String driver = properties.getProperty("DRIVER");
            String timezone = properties.getProperty("TIMEZONE");

            // 가져온 값들을 사용해 DB 커넥션을 해줍니다.
            Class.forName(driver);
            String url = jdbc_url + host + port + db + timezone;
            if (conn == null)
                conn = DriverManager.getConnection(url, username, pw);

            // 성공 문구
//            System.out.println("=============== DB connection established ===============");

            // 성공적으로 커낵션이 만들어 졌으면 true 로 리턴
            return true;

            // TODO:: Exception Handling needs (ENUM CLASS)
        } catch (IOException | ClassNotFoundException | SQLException ee) {
            System.out.println("DB Connection Failed");
            ee.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("DB Connection Failed");
            e.printStackTrace();
            return false;
        }
    }//open()

    /**
     * DB 커넥션을 닫아줄 때 사용 됩니다.
     * 커넥션이 오픈 되어 있는 상태에서만 (Null 이 아닌 경우에서만) 커넥션을 닫을 수 있습니다.
     *
     * execute 할 때 밖에 사용이 되지 않을 것 같지만 혹시 모를 사용을 위해 상속 받은 클래스만 쓸 수 있게 protected 를 해두었습니다.
     *
     * @author : Tae Jin Kim
     * @date : 2024-02-02
     * @return  true  : DB 가 성공적으로 닫힐 경우
     *          false : DB 를 닫는대에 실패 할 경우
     *                : 커넥션이 열려있지 않은데 닫으려고 하는 경우
     * @throws
     *          SQLException : conn.close() 커넥션을 닫을 시 실패할 경우 에러를 발생시킵니다
     *          Exception    : 혹시 모를 에러를 위해서 마지막에 제일 상위에 있는 Exception 을 추가를 해줍니다
     */
    protected boolean close() {
        try {
            // 리소스를 위해서 Connection 을 try 가 성공적으로 이루어 졌을 시 닫아줘야 됩니다
            if (conn != null) {
                conn.close();
//                System.out.println("=============== DB Connection Closed ===============");
                return true;
            } else {
                System.out.println("DB커넥션이 열려있지 않습니다.");
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     *  SQL Query 를 받고 SELECT Query 의 값을 저장해주는 ResultSet 의 값을 받아서 해당 Query 를 실행을 시켜줍니다
     *  SQL SELECT Query 를 실행 시킬때 사용이 됩니다.
     *
     *  DB CRUD 는 권한을 가진 사람 외에는 할 수 없다고 생각을 하여 상속 받은 클래스들만 사용을 할 수 있게 protected 로 설정을 했습니다.
     *
     * @author : Tae Jin Kim
     * @date : 2024-02-02
     * @param strSql : 실행시킬 SQL Query
     * @param rs : SELECT 문의 결과 값을 담아 주는 Object
     * @return rs
     * @throws
     *          SQLException : conn.close() 커넥션을 닫을 시 실패할 경우 에러를 발생시킵니다
     *          Exception    : 혹시 모를 에러를 위해서 마지막에 제일 상위에 있는 Exception 을 추가를 해줍니다
     */
    protected ResultSet execute(String strSql, ResultSet rs)
    {
        try {
            // DB 커넥션을 열어줍니다
            if (conn == null)
                open();
            Statement stObj = conn.createStatement();
            rs = stObj.executeQuery(strSql);

        }catch (SQLNonTransientConnectionException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * SQL Query 를 작동시킬 때 사용 합니다. Insert, Update, 그리고 Delete 문에 사용이 됩니다.
     * 실행된 Query 값은 바로 DB 로 가기 때문에 따로 저장을 한다던지 return 값을 줄 필요가 없습니다
     *
     * DB CRUD 는 권한을 가진 사람 외에는 할 수 없다고 생각을 하여 상속 받은 클래스들만 사용을 할 수 있게 protected 로 설정을 했습니다.
     *
     * @author : Tae Jin Kim
     * @date : 2024-02-02
     * @param strSql : sql query to execute
     * @throws
     *          SQLException : conn.close() 커넥션을 닫을 시 실패할 경우 에러를 발생시킵니다
     *          Exception    : 혹시 모를 에러를 위해서 마지막에 제일 상위에 있는 Exception 을 추가를 해줍니다
     */
    protected void execute(String strSql)
    {
        try {
            if (conn == null)
                open();
            Statement stObj = conn.createStatement();
//            System.out.println(strSql);
            stObj.execute(strSql);

        }  catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            // 리소스를 위해 DB 커넥션을 닫아줍니다
            close();
        }
    }



    protected abstract void SqlQuery_selectOne(int bno, ResultSet rs);
}//ObjectDBIO
