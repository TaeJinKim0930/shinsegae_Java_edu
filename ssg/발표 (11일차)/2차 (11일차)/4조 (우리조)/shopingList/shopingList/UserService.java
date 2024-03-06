package oop.day3.shopingList;
import java.util.*;
import java.util.regex.Pattern;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    String adminId = "";
    String adminPw = "";

    /**
     * 입력받은 아이디의 유효성 검사를 하고, 통과되면 비밀번호를 입력받는 메서드를 호출합니다.
     * @see ShoppingMallMain case9 에서 사용합니다.
     */
    public void insertAdminId() {
        System.out.println("관리자 정보를 입력하세요.");
        System.out.print("아이디 : ");
        adminId = scanner.next();
        if (!Pattern.matches("^[a-zA-Z0-9]*$", adminId)) {
            System.out.println("올바른 형식이 아닙니다.");
            System.out.println("1.다시 입력하기  2.종료");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertAdminId();
                case 2:
                    System.exit(0);
            }
        } else {
            insertAdminPw();
        }
    }

    /**
     * 입력받은 비밀번호의 유효성 검사를 합니다.
     * @see ShoppingMallMain case9에서 사용합니다.
     */
    public void insertAdminPw() {
        System.out.print("비밀번호 : ");
        adminPw = scanner.next();
        if (!Pattern.matches("^[a-zA-Z0-9]*$", adminPw)) {
            System.out.println("올바른 형식이 아닙니다.");
            System.out.println("1.다시 입력하기  2.종료");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertAdminPw();
                case 2:
                    System.exit(0);
            }
        }
    }

    /**
     * 입력받은 아이디, 비밀번호가 관리자 이이디, 비밀번호와 일치하는지 확인하는 메서드 입니다.
     * @see ShoppingMallMain case9에서 사용.
     */
    public void checkAdminAccount(User user) {
        Admin admin = new Admin(user.getName(), user.getContact());
        if (adminId.equals(admin.getId()) && (adminPw.equals(admin.getPassword()))) {
            System.out.println("이름 " + admin.getName() + " 연락처 " + admin.getContact());
            System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }
}
