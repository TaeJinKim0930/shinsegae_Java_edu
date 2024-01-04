package oop.day6.advanced.InterfaceModel;

import model.test.A;

public class Main {
    public static void main(String[] args) {
//        Television television = new Television();
//        television.turnOn();
//        television.turnOff();

//        Audio audio = new Audio();
//        audio.turnOff();
//        audio.turnOn();

        RemoteControl rc = new Television();
        RemoteControl rc2 = new Audio();

        rc.turnOn();
        rc.turnOff();

        rc2.turnOn();
        rc2.turnOff();


    }
}
