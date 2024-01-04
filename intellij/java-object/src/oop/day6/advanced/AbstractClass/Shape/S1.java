package oop.day6.advanced.AbstractClass.Shape;

import java.awt.*;

public class S1 {
    public static void main(String[] args) {
        Circle s1 = new Circle("빨간색", 2.4187744);
        String color = s1.getColor();

        System.out.println(s1.toString());

    }
}
