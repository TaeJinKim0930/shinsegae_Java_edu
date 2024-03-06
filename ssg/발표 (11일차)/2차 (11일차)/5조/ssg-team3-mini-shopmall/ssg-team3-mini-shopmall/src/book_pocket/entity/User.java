package book_pocket.entity;

public class User extends Person {
    public User(String name, String userMobile) {
        super(name, userMobile);
    }

    public User(String name, String userMobile, String address) {
        super(name, userMobile, address);
    }

    @Override
    public String toString() {
        return "현재 고객 정보 : \n" + "이름 : " + getName() + "  연락처 : " + getPhone();
    }
}