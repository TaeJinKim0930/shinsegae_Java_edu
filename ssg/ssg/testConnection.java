import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConnection {
    private static Connection conn = null;
    private static String databaseName = "ssg_db";
    private static String jdbc_url = "jdbc:mysql://localhost:3306/";
    private static String db_id = "root";
    private static String db_pwd = "2023ssg";

//    public void setDb_id(String db_id) {
//        this.db_id = db_id;
//    }
//
//    public void setDb_pwd(String db_pwd) {
//        this.db_pwd = db_pwd;
//    }
//
//    public void setJdbc_url(String jdbc_url) {
//        this.jdbc_url = jdbc_url;
//    }

    // DB Connect
    private static boolean open() {
        try{
            // v0.0.1: oracle DB -> mysql DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
            System.out.println("DB Connection Success");
            return true;
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        try {
            open();

            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }

    }
}
