package oop.interface_quiz;

public class Dog extends Animal{

    Dog(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        distance += speed * hours * 0.5;
    }
}
