package book_pocket.service;

import book_pocket.entity.User;

public class UserService {
    private final User user;

    public UserService(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    void displayUser() {
        System.out.println(user.toString());
    }
}