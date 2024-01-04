package project.project1.shoppingList.service;

public enum StatusEnum {
    ADMIN("Admin"),
    REGULAR_USER("Regular User");

    // 여기에 Admin 이나 Regular User 값이 저장이 됩니다.
    private String role;

    //
    StatusEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
