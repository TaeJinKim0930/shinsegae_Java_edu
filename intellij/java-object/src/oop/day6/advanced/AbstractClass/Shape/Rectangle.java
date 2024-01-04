package oop.day6.advanced.AbstractClass.Shape;



public class Rectangle extends Shape{
    private int length;
    private int width;

    public double area() {
        return length * width;
    }

    Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    public String toString() {
        return "사각형 색삭은 " + getColor() + "그리고 면적은 : " + area();
    }
}
