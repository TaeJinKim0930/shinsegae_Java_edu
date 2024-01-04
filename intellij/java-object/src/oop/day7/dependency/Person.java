package oop.day7.dependency;

public class Person  {
//    // 소유
//    private Phone phone;
//
//    Person(Phone phone) {
//        this.phone = phone;
//    }
//
//    public void createMessage() {
//        String message = "g2";
//        String to = "My pal";
//        // 폰의 문자 전송
//        phone.sendMessage(message, to);
//    }
    public void sendMessage(Phone phone) {
        String to = "my fam";
        String msg = "HoHoHoHo";
        phone.sendMessage(to, msg);
    }

}
