package project.project1.shoppingList.entity;

import project.project1.shoppingList.service.StatusEnum;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private List<Book> cartList = new ArrayList<>();

    public User() {}
    private static volatile User userInstance;
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    User(String id, String pw, StatusEnum role, String name, String phone) {
        // TODO:: role 안나오면 .getRole()로 변경
        super(id, pw, StatusEnum.REGULAR_USER);
        this.name = name;
        this.phone = phone;
    }



    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String contact) {
        this.phone = contact;
    }

    public void printUserInfo() {
        System.out.println("User Name : " + name);
        System.out.println("User Contact : " + phone);
    }


}
