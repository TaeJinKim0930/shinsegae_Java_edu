package model.test;

// Receiver class
public class B {

    public String receiverData = "";

    public void b1() {
        System.out.println("B 타입의 b1() 메소드 실행");
    }

    public void b2() {
        System.out.println("B 타입의 b2() 메소드 실행");
    }

    public void b3(String data) {
        receiverData = data;
        System.out.println("A 클래스에서 전달받은 내용 : " + receiverData);
    }

    public String b4(String data) {
        A a = new A();
        receiverData = a.a3();
        return receiverData + "는 B타입의 x1객체에서 처리하였습니다.";
    }
}