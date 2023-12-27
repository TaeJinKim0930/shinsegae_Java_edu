package oop.interface_1;

public class MultiInterfaceMain {
    public static void main(String[] args) {
        RemoteControl remoteControl = new SmartTv();
        Searchable searchable = new SmartTv();

        remoteControl.turnOn();
        remoteControl.turnOff();
        remoteControl.setVolume(10);
        remoteControl.setMute(true);

        searchable.search("https://www.google.com");
        searchable.channelUp(2);
        searchable.channelDown(3);
    }
}
