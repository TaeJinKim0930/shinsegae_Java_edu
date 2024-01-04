package oop.day2.basic.classEx.sec05.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		//Calculator 객체 생성
		Calculator calculator = new Calculator();
		
		//리턴값이 없는 powerOn() 메소드 호출
		calculator.poewrOn();;
		System.out.println(calculator.power);

		//plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
		//덧셈 결과를 리턴 받아 result1 변수에 대입
		int add = calculator.add(5,6);
		System.out.println(add);

		//divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
		//나눗셈 결과를 리턴 받아 result2 변수에 대입
		int x = 1, y = 2;
		double divide = calculator.divide(1, 2);
		System.out.println(divide);

		//리턴값이 없는 powerOff() 메소드 호출
		calculator.poewrOff();
	}
}