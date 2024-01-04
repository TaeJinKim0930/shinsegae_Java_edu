package oop.day2.basic.classEx.sec03.exam01;

public class CarExample {
	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar1 = new Car();
		//Car 객체의 필드값 읽기

		Car myCar2 = new Car("Honda", "CR-V", "White", 350, 0);
		System.out.println(myCar2.getCompany() + myCar2.getColor());
		myCar2.setSpeed(10);
	}
}