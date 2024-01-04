package oop.day3;

public class Student {
    int id;
    String name;

    Student() {}
    Student (int id, String name) {
        this.id = id;
        this.name = name;
    }

    void insertRecord(int ids,String names) {
        id = ids;
        name = names;
    }

    void printInfo() {
        System.out.println(id + " " + name);
    }


}
