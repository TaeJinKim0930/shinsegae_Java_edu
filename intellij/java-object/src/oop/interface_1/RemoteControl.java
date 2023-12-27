package oop.interface_1;

public interface RemoteControl {
    // interface 는 public static final 을 안붙여도 컴파일 할 때 붙음
    int MAX_VOLUME = 30;
    int MIN_VOLUME = 0;


    // 2. 추상메소드: abstract, {} 바디가 없는 메소드(메소드 선언부만 작성)
    void turnOn();

    void turnOff();

    void setVolume(int volumne);

    // 3. default instance method; 인터페이스에서 완전한 실행코드를 가짐
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("Muted");
            setVolume(MIN_VOLUME);
        }
    }

    // 4. public 정적 메소드
    static void changeWheel() {
        System.out.println("자동차 휠을 교체합니다.");
    }


}
