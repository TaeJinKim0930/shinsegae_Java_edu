package book_pocket.entity;

public class Admin extends Person {
    private final String ID_ADMIN = "admin";
    private final String PASSWORD_ADMIN = "admin1234";

    private static Admin instanceSingleton = null;

    private Admin(String name, String phone) {
        super(name, phone);
    }

    public static Admin getInstance(String name, String phone) {
        if(instanceSingleton == null) {
            instanceSingleton = new Admin(name, phone);
        }
        return instanceSingleton;
    }

    public String getId() {
        return ID_ADMIN;
    }

    public String getPassword() {
        return PASSWORD_ADMIN;
    }

    @Override
    public String toString() {
        return "이름 " + getName() + "\t연락처" + getPhone() + "\n" + "아이디 "+ getId() + "\t비밀번호 "+ getPassword();
    }
}