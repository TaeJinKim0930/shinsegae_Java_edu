package oop.day6.advanced.InterfaceModel;

public class Audio implements RemoteControl{
    @Override
    public void turnOn() {
        System.out.println("Audio 전원 On");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio 전원 Off");
    }
}
