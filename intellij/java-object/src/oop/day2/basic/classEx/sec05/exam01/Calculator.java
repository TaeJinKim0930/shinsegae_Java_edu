package oop.day2.basic.classEx.sec05.exam01;

public class Calculator {
    //리턴값이 없는 메소드 선언
    boolean power = false;

    //리턴값이 없는 메소드 선언
    public void poewrOn() {
        this.power = true;
        System.out.println("전원on");
    }

    public void poewrOff() {
        this.power = true;
        System.out.println("전원on");
    }

    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 int를 리턴하는 메소드 선언
    public int add(int first, int second) {
        return first + second;
    }

    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 double을 리턴하는 메소드 선언
    public double divide(int x, int y) {
        return (double)(x / y);
    }

}