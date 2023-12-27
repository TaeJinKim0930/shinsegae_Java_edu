package oop.interface_4;

public class DriveMain {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Texi texi = new Texi();
        Bus bus = new Bus();

        driver.drive(bus); // promotion -> overriding 메소드 호출 -> 다형성
        driver.drive(texi);


    }

    // 인터페이스 매개변수를 갖는 메소드
    public static void ride(Vechicle vechicle) {
        if (vechicle instanceof Bus bus) bus.checkFare();
        vechicle.run();
    }
}
