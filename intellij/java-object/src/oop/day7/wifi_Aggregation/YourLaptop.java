package oop.day7.wifi_Aggregation;

public class YourLaptop {
    private Wifi internet;

    YourLaptop(Wifi wifi) {
        this.internet = wifi;
    }

    void openChrome() {
//        this.internet 인터넷을 이용하여 크롬을  연다
        this.internet.connection();
    }
}
