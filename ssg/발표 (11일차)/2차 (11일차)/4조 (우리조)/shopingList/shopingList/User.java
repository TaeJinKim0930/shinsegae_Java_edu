package oop.day3.shopingList;

public class User {
    private String name;
    private String contact;

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    User() {}

    User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }


}
