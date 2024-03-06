import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MultiBoardSelectEx {
    public static void main(String[] args) {
        Connection conn = null;
        List<Board> boardList = new ArrayList<>();

        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");


            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul",
                    "shinsaegeadmin",
                    "2023ssg"
            );

            String sql = "SELECT * " +
                    "FROM boards ";

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //SQL문 실행
            ResultSet rs = pstmt.executeQuery(sql);
            int size = 0;

            // user 값 얻기
            while (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));

                size = rs.getRow();
                boardList.add((board));

                // 파일 다운로드
                Blob blob = board.getBfiledata();
                if (blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream("C:/temp/" + board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }
            rs.close();

            System.out.println("저장된 행 수: " + size);

            System.out.println("================== List ==================");
            boardList.stream().forEach(System.out::println);
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
