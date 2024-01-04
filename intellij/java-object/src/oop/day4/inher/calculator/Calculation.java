package oop.day4.inher.calculator;

public class Calculation {
    private int a;

    Calculation() {}

    Calculation(int a ) {
        this.a = a;
    }

    public int getA(int a) {
        return a;
    }
    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }


}
