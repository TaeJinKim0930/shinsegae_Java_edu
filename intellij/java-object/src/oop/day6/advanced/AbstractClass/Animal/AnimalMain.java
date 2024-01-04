package oop.day6.advanced.AbstractClass.Animal;

public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.printSound();

        Cat cat = new Cat();
        cat.printSound();

        Animal dog1 = new Dog();
        Animal cat1 = new Cat();

        dog.tailWagging();

    }
}
