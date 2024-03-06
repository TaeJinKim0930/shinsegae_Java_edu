import java.io.FileInputStream;
import java.sql.*;

public class BoardUpdateExample {
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


            //매개변수화된 SQL문 작성
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("bfilename = ? ,")
                    .append("bfiledata = ? ")
                    .append(" where bno = ? ")
                    .toString();

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "chrismas.jpg");
            pstmt.setBlob(2, new FileInputStream("chrismas.jpg"));
            pstmt.setInt(3, 1);

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("업데이트 행 수 : " + rows);



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
