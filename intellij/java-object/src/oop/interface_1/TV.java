package oop.interface_1;

public class TV implements RemoteControl {
    private int volumne;
    @Override
    public void turnOn() {
        System.out.println("turn up");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off");
    }


    @Override
    public void setVolume(int volumne) {
        // 인터페이스 상수 max 와 min 을 사용하여 제한
        if (volumne > MAX_VOLUME) {
            this.volumne = MAX_VOLUME;
        } else if (volumne < MIN_VOLUME) {
            this.volumne = MIN_VOLUME;
        } else {
            this.volumne = volumne;
        }
    }

    @Override
    public void setMute(boolean mute) {
        if (mute) {
            System.out.println("Muted");
            setVolume(MIN_VOLUME);
        }
    }
}
