package oop.day6.advanced.AbstractClass.Animal;

public class Dog extends AbstractDog{
    @Override
    public void printSound() {
        System.out.println("DogDog!");
    }

    @Override
    public void tailWagging() {
        System.out.println("Wag Wag");
    }
}
