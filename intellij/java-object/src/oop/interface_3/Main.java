package oop.interface_3;

public class Main {
    public static void main(String[] args) {
        // 구현객체 생성
        B b = new B();
        C c = new C();
        B bc = new C();
        System.out.println("========================");

        D d = new D();
        E e = new E();
        System.out.println("========================");

        // 인터페이스 변수 선언
        A a;

        // 변수에 구현 객체 대입 (자동 타입 변환)
        a = b;       // 자동타입변환 Promotion
        B b1 = (B)a; // 다시 돌려 놓기 Casting

        a = c;
        a = d;
        a = e;

    }
}
