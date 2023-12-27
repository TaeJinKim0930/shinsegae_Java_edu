package oop.interface_1;

public class ServiceMain {
    public static void main(String[] args) {
        // interface 는 구현객체가 불가능 하기 때문에 new Service() 가 불가능!
        Service service = new ServiceImpl(); // interface 변수 선언하고 구현객체 대입

        service.defaultExampleMethodA();
        service.defaultExampleMethodB();

        Service.staticExampleMethodA();
        Service.staticExampleMethodB();
    }
}
