package book_pocket.service;

import book_pocket.entity.Admin;
import book_pocket.entity.User;

import java.util.Scanner;

public class AdminService {
    private Scanner sc;
    private Admin admin;

    public AdminService(Scanner sc) {
        this.sc = sc;
    }

    boolean authenticate(User user, String id, String password) {
        admin = Admin.getInstance(user.getName(), user.getPhone());
        boolean isAuthenticated = id.trim().equals(admin.getId()) && password.trim().equals(admin.getPassword());
        if (isAuthenticated) {
            System.out.println("이름 " + admin.getName() + "  연락처 " + admin.getPhone());
            System.out.println("아이디 " + admin.getId() + "  비밀번호 " + admin.getPassword());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
        return isAuthenticated;
    }
}