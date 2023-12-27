package oop.day4.inher.calculator;

public class Inheritance extends Calculation{
    int b ;
    Inheritance() {}

    Inheritance(int b) {
        super();
        this.b = b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public void printCal(int a, int b) {
        System.out.println("두 수의 덧셈 : " + addition(a, b));
        System.out.println("두 수의 뺄셈 : " + subtraction(a, b));
        System.out.println("두 수의 곱셈 : " + multiplication(a, b));
    }
}
