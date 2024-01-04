package oop.interface_1;

public class RemoteControlEx {
    /**
     * 1. public 상수 필드 : 상수는 구현객체와 상관없는 인터페이스 멤버이므로 바로 접근해서 상수값을 읽을 수 있음.
     * 2. public 추상 메소드 :
     * 3. public 디폴트 메소드
     */
    public static void main(String[] args) {
        // 1. 상수 필드
        System.out.println(RemoteControl.MAX_VOLUME);

        // 2.
        RemoteControl SAMSUNG = new TV();
        SAMSUNG.turnOn();
        int max = SAMSUNG.MAX_VOLUME;
        int min = SAMSUNG.MIN_VOLUME;
        SAMSUNG.setVolume(20);
        SAMSUNG.turnOff();

        // 2-1 (숨김버전, 다형성)
        RemoteControl remoteControl = new TV();
        remoteControl.turnOn();
        int max2 = remoteControl.MAX_VOLUME;
        int min2 = remoteControl.MIN_VOLUME;
        remoteControl.setVolume(20);
        remoteControl.turnOff();
    }
}
