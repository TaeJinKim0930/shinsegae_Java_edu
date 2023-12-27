package oop.day6.advanced.AbstractClass.Shape;

import java.util.PrimitiveIterator;

public class Circle extends Shape {
    private double radius;
    @Override
    public double area() {
        return radius * 2 * Math.PI;
    }

    Circle(String color, double radius) {
        super(color);
        System.out.println("Circle 클래스 생성자 호출");
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "원 색상은 " + getColor() + " 그리고 면적은 : " + area();
    }
}
