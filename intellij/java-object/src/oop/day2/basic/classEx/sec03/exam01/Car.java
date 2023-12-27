package oop.day2.basic.classEx.sec03.exam01;

public class Car {
	//필드(멤버) 선언
    // 클래스는 멤버와 메소드를 가지고 있다
    private String company;
    private String model = "grandeur";
    private String color = "black";
    private int maxSpeed;
    private int speed;

    public Car() {}

    // 생성자 오버로딩
    public Car(String company, String model, String color, int maxSpeed, int speed) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.speed = speed;
    }

    // Getter = 정보 변경 불가능 하게 하는 거
    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }



    public String getColor() { return this.color; }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}