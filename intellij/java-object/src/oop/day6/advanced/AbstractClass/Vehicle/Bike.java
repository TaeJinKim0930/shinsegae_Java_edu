package oop.day6.advanced.AbstractClass.Vehicle;

public class Bike extends TwoWheeler {

    @Override
    public void printType() {
        System.out.println("이것은 자전거 입니다");
    }

    @Override
    public void printPrice() {
        System.out.println("가격 : 150,000");
    }

    public void printBrand() {
        System.out.println("브랜드 : 삼천리");
    }
}
