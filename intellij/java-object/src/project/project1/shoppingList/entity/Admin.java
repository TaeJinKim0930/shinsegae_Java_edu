package project.project1.shoppingList.entity;


import project.project1.shoppingList.service.StatusEnum;

public class Admin extends Person {
    // TODO:: Use Builder class
//    private final String status = "Admin";

    // To Prevent waiting state in multithreading
    private static volatile Admin adminInstance;


    public Admin(String id, String pw) {
        super(id, pw);
    }

    public Admin(String id, String pw, StatusEnum role) {
        super(id, pw, StatusEnum.ADMIN);
    }

    public static Admin getInstance() {
        Admin result = adminInstance;
        if (result == null) {
            // to prevent multithreading
            synchronized (Admin.class) {
                result = adminInstance;
                if (result == null) {
                    adminInstance = result = new Admin("Admin", "Admin1234");
                }
            }
        }
        return result;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }


    public String getPw() {
        return pw;
    }
}