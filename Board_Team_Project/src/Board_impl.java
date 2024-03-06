import org.json.JSONObject;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Board_impl extends ObjectDBIO {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Scanner in = new Scanner(System.in);


    /**
     * Boards DB 에 있는 값을 전부 가져옵니다.
     * JSON 형식을 사용해서 while loop 을 돌때마다 json 객체에 쌓아 두고 한번에 출력합니다.
     *
     * @return obj : 혹시 몰라서 일단 object 로 리턴해둿는데 필요 없으면 삭제 가능
     * TODO::리스트를 불러올때 bfiledata 를 어떤식으로 나중에 처리할지. 프론트에 어떤식으로 보내줄지 구상
     */
    public JSONObject list() {
        System.out.println("=============================== Board List ===============================");
        String sql = "SELECT * FROM boards";
        ResultSet rs = null;
        JSONObject obj = new JSONObject();

        try {
            rs = super.execute(sql, rs);


            if(rs == null) System.out.println("보드가 비어있습니다");

            while (rs.next()) {
                Board board = new Board(
                        rs.getInt("bno"),
                        rs.getString("btitle"),
                        rs.getString("bcontent"),
                        rs.getString("bwriter"),
                        rs.getDate("bdate"),
                        rs.getString("bfilename"),
                        rs.getBlob("bfiledata")
                );
                obj.accumulate("Board_List", board);
            }

            System.out.println(obj);


            System.out.println("==========================================================================");
            mainMenu();

            return obj;
        } catch (SQLNonTransientConnectionException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet and connection in separate finally blocks
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }



        }
        return obj;

    }// list

    /**
     * 유저들이 기능을 사용 할 수 있게 메인 메뉴를 불러옵니다
     */
    public void mainMenu() {
        boolean state = true;

        try {
            while (state) {
                System.out.println();
                System.out.println("--------------------------------------------------");
                System.out.println("1.메인 메뉴: 1.Create | 2. Read | 3. Clear | 4.Exit");
                System.out.print("메뉴 선택 ");
                String menuNumber = br.readLine();
                System.out.println();

                //분기할 메소드 지정
                switch (menuNumber) {
                    case "1" -> create();
                    case "2" -> read();
                    case "3" -> clear();
                    case "4" -> System.exit(0);
                }
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 게시글을 작성해주는 메소드 입니다
     * StringBuilder 를 사용해서 sql Query 문을 저장을 하고
     * 유저에게 받아온 값을 Board 객체에 저장을 해서
     * PrepareStatement 를 사용해 DB 에 넣어줍니다
     *
     * @exception : 보드에 추가를 실패하면 에러문구를 발생합니다
     * 파일이 없는 파일일 경우 에러처리 기능이 필요합니다
     */
    private void create() {
        try {
            open();
            String updateSql = new StringBuilder()
                    .append("INSERT INTO boards (")
                    .append("btitle, ") // 1
                    .append("bcontent,") // 2
                    .append("bwriter, ") // 3
                    .append("bfilename, ") // 4
                    .append("bfiledata ") // 5
                    .append(") values (?,?,?,?,?)")
                    .toString();

            Board board = new Board();
            System.out.println("추가 할 제목을 입력해주세요");
            board.setBtitle(in.next());
            System.out.println("추가 할 내용을 입력해주세요");
            board.setBcontent(in.next());
            System.out.println("추가 할 작가의 이름을 입력해주세요");
            board.setBwriter(in.next());
            System.out.println("추가 할 파일 이름을 입력해주세요 : ex) snow.jpg");
            board.setBfilename(in.next());

            PreparedStatement pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, board.getBtitle());
            pstmt.setString(2, board.getBcontent());
            pstmt.setString(3, board.getBwriter());
            pstmt.setString(4, board.getBfilename());
            // TODO:: 사진 파일이 없으면 다시 입력하게 해야 될 듯. 없는 파일이면 FileNotFoundException 뜸
            pstmt.setBlob(5, new FileInputStream(board.getBfilename()));

            int rows = pstmt.executeUpdate();
            System.out.println("추가된 행 수 : " + rows);

            if (rows == 0) {
                System.out.println("보드 추가가 되지 않았습니다..");
            }
            pstmt.close();

        } catch (FileNotFoundException fe) {
            System.out.println("파일이 없어요");
//            fe.printStackTrace();
        } catch (RuntimeException re) {
            System.out.println("run Filed");
            re.printStackTrace();
        } catch (SQLNonTransientConnectionException snt) {
            snt.printStackTrace();
        } catch (SQLException se) {
            System.out.println("보드를 추가 하는대에 실패하였습니다.");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("오.. 에런데? 일해라");
            e.printStackTrace();
        } finally {
//            if (conn != null) {
//                try {
//                    //연결 끊기
//                    conn.close();
//                } catch (SQLException e) {
//                }
//            }
        }
    }

    /**
     * 메인메뉴에서 2번(Read) 로 들어 올 경우 update, delete, list 기능을 고를 수 있게 해줍니다
     * update  : 게시글 수정 (bno)
     * delete  : 원하는 게시글 삭제 (bno)
     * list    : 모든 게시글의 리스트를 출력합니다
     * default : 잘못된 유저 값이므로 다시 시도하게 합니다
     *
     */
    private void read() {
        System.out.println("1. UPDATE | 2. DELETE | 3. LIST | 4. 이전 메뉴");
        switch (in.nextInt()) {

            case 1 -> update();
            case 2 -> delete();
            case 3 -> list();
            case 4 -> {
                return;
            }
            default -> System.out.println("숫자를 다시 입력해주세요");
        }
    }

    /**
     * bno 를 이용하여 원하는 게시글만 읽어옵니다.
     * @param bno : 게시글 번호
     * @param rs : select 값
     */
    private void readOne(int bno, ResultSet rs) {
        try {
            SqlQuery_selectOne(bno, rs);

            if (rs.next()) {
                Board boards = new Board();
                boards.setBno(rs.getInt("bno"));
                boards.setBtitle(rs.getString("btitle"));
                boards.setBcontent(rs.getString("bcontent"));
                boards.setBwriter(rs.getString("bwriter"));
                boards.setBdate(rs.getDate("bdate"));

                System.out.println(boards);
            } else System.out.println("존재하지 않는 게시물입니다.");


            rs.close();
            rs.isClosed();
            super.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * bno 값으로 원하는 게시글을 삭제 합니다
     *
     * @exception : 유저가 입력한 게시물 번호(bno) 가 없다면 에러 문구를 출력합니다
     */
    private void delete() {
        System.out.println("게시물 삭제");
        try {
            open();
            String sql = "DELETE FROM boards WHERE bno = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("삭제할 게시물의 bno를 입력하세요");
            int num = Integer.parseInt(br.readLine());
            pstmt.setInt(1, num);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제할 게시물 번호가 틀렸습니다");
            }
            pstmt.close();
//            close();
        } catch (FileNotFoundException fe) {
            System.out.println("파일이 없어요");
//            fe.printStackTrace();
        } catch (SQLException | IOException s) {
            System.out.println("값 넣기 실패!");
//            s.printStackTrace();
        } catch (NumberFormatException ne) {
            System.out.println("번호를 입력해주세요");
//            ne.printStackTrace();
        }

    }

    /**
     * bno 를 이용하여 원하는 게시글을 수정합니다.
     * TODO::엔터를 칠 경우 기존 값을 유지하는 기능
     * TODO::마지막에 수정을 원하는지 원하지 않는지 다시 유저에게 체크를 하는 기능
     */
    private void update() {
        System.out.println("게시물 수정");
        try {
            open();
            String sql = new StringBuilder().append("UPDATE boards SET ")
                    .append("btitle = ?,")
                    .append("bcontent = ?,")
                    .append("bwriter = ?,")
                    .append("bfilename = ?,")
                    .append("bfiledata = ? ")
                    .append("WHERE bno = ?")
                    .toString();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("수정할 게시물의 bno를 입력하세요");
            int num = Integer.parseInt(br.readLine());

            System.out.println("수정할 제목을 입력하세요");
            String title = br.readLine();
            System.out.println("수정할 내용을 입력하세요");
            String content = br.readLine();
            System.out.println("수정할 작성자명을 입력하세요");
            String writer = br.readLine();
            System.out.println("수정할 파일명을 입력하세요");
            String filename = br.readLine();
            String filedata = filename;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, writer);
            pstmt.setString(4, (filedata.isEmpty()) ? null : filename);  // 파일 데이터가 없으면 filename도 null로 설정

            // 파일 데이터가 입력되었을 경우에만 Blob 설정
            if (!filedata.isEmpty()) {
                File file = new File(filedata);
                FileInputStream fr = new FileInputStream(file);
                pstmt.setBinaryStream(5, fr, (int) file.length());
            } else {
                pstmt.setNull(5, Types.BLOB);
            }
            pstmt.setInt(6, num);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("게시물 수정 성공");
            } else {
                System.out.println("수정할 게시물의 번호를 틀렸습니다");
            }
            pstmt.close();

        } catch (FileNotFoundException fe) {
            System.out.println("파일이 없어요");
//            fe.printStackTrace();
        } catch (SQLException | IOException s) {
            System.out.println("값 넣기 실패!");
//            s.printStackTrace();
        } catch (NumberFormatException ne) {
            System.out.println("번호를 입력해주세요");
//            ne.printStackTrace();
        }

    }

    /**
     *
     */
    private void clear() {
        try {
            String deleteQuery = "delete from boards where bno LIKE \"%\" ";
            super.execute(deleteQuery);
            System.out.println("Your board is clear now");
        } catch (Exception e) {
            System.out.println("Deletion did not make");
            e.printStackTrace();
        }
    }

    @Override
    protected void SqlQuery_selectOne(int bno, ResultSet rs) {
        String sql = String.format("SELECT * " + "FROM boards" + " WHERE bno = %d", bno);
        rs = execute(sql, rs);
    }
}//Board_impl
