package oop.day7.classModel_ex02;

public class Gcompany extends Car{
    private int number;

    Gcompany() {}

    Gcompany(int number, int year, String name) {
        super(year, name);
        this.number = number;
    }



    public void local_number() {
        System.out.println(number);
    }
}
