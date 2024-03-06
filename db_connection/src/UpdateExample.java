import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver ok!");

            //연결하기
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul", "shinsaegeadmin", "2023ssg");

            //매개변수화된 SQL문 작성

//            String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail)" + "values(?,?,?,?,?)";
            String sql = new StringBuilder()
                    .append("UPDATE users SET ")
                    .append("userpassword = ? ")
                    .append("WHERE userid = ? ")
                    .toString();


            System.out.println(sql);
            //PreparedStatement 얻기 및 값 지정

            // update
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "123465");
            pstmt.setString(2, "ssg");


            // insert
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,"ssg");
//            pstmt.setString(2,"신세계");
//            pstmt.setString(3, "1234");
//            pstmt.setInt(4,30);
//            pstmt.setString(5,"ssg@gmail.com");


            //SQL문 실행

            // insert
//            int rows = pstmt.executeUpdate();
//            System.out.println("저장된 행 수: " + rows);

            int rows = pstmt.executeUpdate();
            System.out.println("업데이트된 행 수: " + rows);

            //PreparedStatement 닫기
            pstmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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