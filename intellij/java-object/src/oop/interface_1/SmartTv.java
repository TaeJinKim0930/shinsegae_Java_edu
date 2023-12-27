package oop.interface_1;

public class SmartTv implements RemoteControl, Searchable {
    private int volume;
    private int channel;

    @Override
    public void turnOn() {
        System.out.println("smart tv on");
    }

    @Override
    public void turnOff() {
        System.out.println("smart tv off");
    }

    @Override
    public void setVolume(int volumne) {
        // 인터페이스 상수 max 와 min 을 사용하여 제한
        if (volumne > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if (volumne < MIN_VOLUME) {
            this.volume = MIN_VOLUME;
        } else {
            this.volume = volumne;
        }
    }

    @Override
    public void setMute(boolean mute) {
        RemoteControl.super.setMute(mute);
    }

    @Override
    public void search(String url) {
        System.out.println(url + " 검색중");
    }

    @Override
    public void channelUp(int channel) {
        this.channel++;
    }

    @Override
    public void channelDown(int channel) {
        this.channel--;
    }
}
