package project.project1.shoppingList.service;
import project.project1.shoppingList.entity.Admin;
import project.project1.shoppingList.entity.User;

import java.util.*;
import java.util.regex.Pattern;

public class UserService {
    private User user;

    Scanner scanner = new Scanner(System.in);
    private String adminId = "";
    private String adminPw = "";

    private static UserService userInstance;

    public static UserService getInstance() {
        UserService result = userInstance;
        if (result == null) {
            // to prevent multithreading
            synchronized (Admin.class) {
                result = userInstance;
                if (result == null) {
                    userInstance = result = new UserService();
                }
            }
        }
        return result;
    }

    public void userLogin(String name, String phone) {
        try {
            user = new User(name, phone);
            System.out.printf("환영합니다 %s 고객님\n", name);
        } catch (InputMismatchException ime) {
            System.out.println("유저정보를 제대로 입력해주세요");
        }
    }

    public User getUser() {
        return user;
    }

    public void menuGuestInfo() {
        System.out.println("현재 고객 정보 : ");
        System.out.printf("이름 : %s\n연락처 : %s\n", user.getName(), user.getPhone());
    }

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
//        Admin admin = new Admin(user.getName(), user.getContact());
        if (adminId.equals(user.getId()) && (adminPw.equals(user.getPw()))) {
            System.out.println("이름 " + user.getName() + " 연락처 " + user.getPhone());
            System.out.println("아이디 " + user.getId() + " 비밀번호 " + user.getPw());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }
}
