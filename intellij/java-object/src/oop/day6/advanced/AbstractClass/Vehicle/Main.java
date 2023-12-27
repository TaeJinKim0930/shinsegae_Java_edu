package oop.day6.advanced.AbstractClass.Vehicle;

import model.test.C;

public class Main {
    public static void main(String[] args) {
        Bike myBike = new Bike();
        myBike.printType();
        myBike.printBrand();
        myBike.printPrice();

        System.out.println("--------------------");

        Car myCar = new Car();
        myCar.printType();
        myCar.printBrand();
        myCar.printPrice();
    }
}
