package project.project1.shoppingList.entity;

import project.project1.shoppingList.service.StatusEnum;

public abstract class Person {
    // fields are protected since they will only be accessed from Admin and User, which are child classes
    protected String name;
    protected String phone;

    protected String id;

    protected String pw;

    private StatusEnum role;

    Person() {}

    Person(String id, String pw){
        this.name = id;
        this.phone = pw;
    }

    Person(String id, String pw, StatusEnum role){
        this.name = id;
        this.phone = pw;
        this.role = role;
    }

    Person(String name, String phone, String id, String pw) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.pw = pw;
    }
}
