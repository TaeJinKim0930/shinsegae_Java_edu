import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSelect {
    public static void main(String[] args) {
        Connection conn = null;
        List<User> usersArr = new ArrayList<>();

        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");


            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul",
                    "shinsaegeadmin",
                    "2023ssg"
            );

            String sql = "SELECT userid, username, userpassword, userage, useremail " +
                    "FROM users ";
//            System.out.println(sql);

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "ssg");


            //SQL문 실행
            ResultSet rs = pstmt.executeQuery(sql);
            int size = 0;

            // user 값 얻기
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt("userage"));
                user.setUserEmail(rs.getString("useremail"));
                System.out.println(user.toString());
                usersArr.add(user);

                size = rs.getRow();
            }

            System.out.println("저장된 행 수: " + size);
            rs.close();

            System.out.println("================== List ==================");
            usersArr.stream().forEach(System.out::println);
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
