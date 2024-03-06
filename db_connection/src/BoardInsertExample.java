import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul",
                    "shinsaegeadmin",
                    "2023ssg"
            );
          /*
          * create table boards (
             bno             int             primary key auto_increment,
             btitle          varchar(100)    not null,
             bcontent        longtext        not null,
             bwriter         varchar(50)     not null,
             bdate           datetime        default now(),
             bfilename       varchar(50)     null,
             bfiledata     longblob      null
          );
          * */

            //매개변수화된 SQL문 작성
//        String sql = "INSERT INTO boards" +
//              "(btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"
//              +  "VALUES('오늘은 JDBC 학습', 'MYSQL JDBC 라이브러리 학습중' , 'ssg', now(),'snow.jpg', 'binaryData')";
//
            String sql = "INSERT INTO boards" +
                    "(btitle, bcontent, bwriter, bfilename, bfiledata)"
                    +  "VALUES(?, ?, ?, ?, ?)";


            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "오늘은 JDBC 학습");
            pstmt.setString(2, "MYSQL JDBC 라이브러리 학습중");
            pstmt.setString(3, "ssg");
            pstmt.setString(4, "snow.jpg");
            pstmt.setBlob(5, new FileInputStream("snow.jpg"));


            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);

            //bno 값 얻기
            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys(); // bno 컬럼의 값을 리턴 받기
                if (rs.next()) {
                    int bno = rs.getInt(1);
                    System.out.println("bno = " + bno);
                }
                rs.close();
            }


            //PreparedStatement 닫기
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}