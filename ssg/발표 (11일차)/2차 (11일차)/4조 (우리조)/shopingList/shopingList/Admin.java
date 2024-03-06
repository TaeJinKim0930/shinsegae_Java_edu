package oop.day3.shopingList;

public class Admin extends User {
    private final String id = "Admin";
    private final String password = "Admin1234";

    public Admin(String name, String contact) {
        super(name, contact);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}