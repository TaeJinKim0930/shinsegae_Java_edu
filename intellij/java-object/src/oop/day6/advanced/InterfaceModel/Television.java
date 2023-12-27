package oop.day6.advanced.InterfaceModel;

public class Television implements RemoteControl {

    @Override
    public void turnOn() {
        System.out.println("TV 전원 On");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원 Off");
    }
}
