package oop.day7.classModel_ex02;

public class Scompany extends Car{
    private int cc;

    Scompany(){}
    Scompany(int cc, int year, String name) {
        super(year, name);
        this.cc = cc;
    }
    public void getSpeed() {

    }
}
