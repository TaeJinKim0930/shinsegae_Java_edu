package oop.collection.list.board;

import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardExample {
    //field
    private Scanner sc = new Scanner(System.in);
    private List<Board> boards = new ArrayList<Board>();
    // constructor

    //method
    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("1.메인 메뉴: 1.Create | 2.Read | 3. Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.next();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();   //게시물 생성 기능
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> System.out.println("h?");
        }
    }

    public void subMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("1.보조 메뉴: 1.Update | 2.Delete | 3. List");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.next();
        System.out.println();

        switch (menuNo) {
            case "1" -> update();   //게시물 생성 기능
            case "2" -> delete();
            case "3" -> subList();
            default -> System.out.println("h?");
        }
    }

    public void subList(){}
    public void delete() {

    }

    public void update() {
        System.out.print("bno: ");
        int bno = sc.nextInt();
        sc.nextLine();

        System.out.println("[수정 내용 입력]");
        Board updateBoard = new Board();

        updateBoard.setBno(boards.size() + 1);
        System.out.print("제목 : ");
        updateBoard.setBtitle(sc.next());

        System.out.print("내용 : ");
        updateBoard.setBcontent(sc.next());

        System.out.print("작성자 : ");
        updateBoard.setBwriter(sc.next());

        updateBoard.setBdate(getCurrentDate());

        //보조메뉴 출력
        System.out.println("---------------------------------------");
        System.out.println("보조 메뉴: 1. Ok  |   2. Cancel");
        System.out.print("메뉴 선택: ");

        String menuNo = sc.next();


        // 만약에 보조메뉴에서 Ok 를 하면 board 에 넣어주기
        if (menuNo.equals("1")) {
            try {
                boards.forEach(board -> {
                    if (board.getBno() == bno) {
                        board = updateBoard;
                    }
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exit();
            }
        }    //게시물 목록 출력

        list();
    }


    public void list() {
        System.out.println("========================================================================================");
        System.out.println("[게시물 목록]");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-8s%-14s%-18s%-42s\n", "no", "writer", "date", "title");
        System.out.println("----------------------------------------------------------------");

        read();
        mainMenu();
    }


    private void exit() {
        System.out.println("***exit()메소드 실행됨 프로그램 종료합니다.");
        System.exit(0);
    }

    private void clear() {
        boards.clear();
        mainMenu();
    }

    private void read() {
        try {
            boards.forEach(board -> {
                if (boards.isEmpty()) {
                    System.out.println("게시물이 비여있습니다.");
                } else {
                    System.out.printf(
                            "번호: %-6s 작가: %-8s 작성일: %-16s 제목: %-40s\n",
                            board.getBno(),
                            board.getBwriter(),
                            board.getBdate(),
                            board.getBtitle()
                    ); //sout
                }
                System.out.println("원하시는 게시물의 번호를 입력해 주세요.");
                int bno = sc.nextInt();
                sc.nextLine();
                System.out.println("[게시물 읽기]");
                readOne(bno);
            }); //foreach
            mainMenu();


        } catch (Exception e) {
            System.out.println("hhh?");
            e.printStackTrace();
        }
    }


    private void readOne(int bno) {
        for (Board row : boards) {
            if (row.getBno() == bno) {
                System.out.printf("##########\n번호: %-6s\n작가: %-12s\n작성일: %-16s\n제목: %-40s\n##########\n", row.getBno(), row.getBwriter(), row.getBdate(), row.getBtitle());
            }
        }
    }

    private void create() {
        System.out.println("***create()메소드 실행됨");

        Board row = new Board();
        System.out.println("[새 게시물 입력]");

        row.setBno(boards.size() + 1);
        System.out.print("제목 : ");
        row.setBtitle(sc.next());

        System.out.print("내용 : ");
        row.setBcontent(sc.next());

        System.out.print("작성자 : ");
        row.setBwriter(sc.next());

        row.setBdate(getCurrentDate());


        //보조메뉴 출력
        System.out.println("---------------------------------------");
        System.out.println("보조 메뉴: 1. Ok  |   2. Cancel");
        System.out.print("메뉴 선택: ");

        String menuNo = sc.next();


        // 만약에 보조메뉴에서 Ok 를 하면 board 에 넣어주기
        if (menuNo.equals("1")) {
            try {
                boards.add(row);
                System.out.println("게시물 추가 완료!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exit();
            }
        }    //게시물 목록 출력

        list();

    }

    public String getCurrentDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        return date.format(new Date());
    }


    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();
        boardExample.list();
    }

}
