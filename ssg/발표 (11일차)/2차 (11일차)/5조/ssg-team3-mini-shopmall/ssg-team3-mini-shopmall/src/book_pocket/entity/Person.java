package book_pocket.entity;

public class Person {
    private String name;
    private String userMobile;
    private String address;

    public Person(String name, String userMobile) {
        this.name = name;
        this.userMobile = userMobile;
    }

    public Person(String name, String userMobile, String address) {
        this.name = name;
        this.userMobile = userMobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return userMobile;
    }

    public String getAddress() {
        return address;
    }
}