package oop.day7.wifi_Aggregation;

public class MyLaptop {
    private Wifi internet;

    MyLaptop() {
        // 와이파이 공유
//        this.internet = wifi;
        // 와이파이 비공유
        this.internet = new Wifi();
    }

    void openBrowser() {
//        this.internet 인터넷을 이용하여 브라우저를 동작한다
        this.internet.connection();
    }
}
