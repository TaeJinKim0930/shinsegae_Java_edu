package oop.interface_quiz;

public class Chicken extends Animal implements Cheatable{


    Chicken(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        distance += hours * speed;
    }

    @Override
    public void fly() {
        distance += this.speed * 2;
    }
}
