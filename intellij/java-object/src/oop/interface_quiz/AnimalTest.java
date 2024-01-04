package oop.interface_quiz;

import model.test.C;

public class AnimalTest {
    public static void main(String[] args) {
        Dog dog = new Dog(8);
        Chicken chicken = new Chicken(3);
        Chicken cheatableChicken = new Chicken(5);

        for (int i = 1; i < 4; i++) {
            System.out.printf("%d시간 후\n", i);
            dog.run(1);
            chicken.run(1);
            if (cheatableChicken instanceof Cheatable) {
                cheatableChicken.fly();
            }

            System.out.println("개의 이동거리=" + (dog.getDistance()));
            System.out.println("닭의 이동거리= " + (chicken.getDistance()));
            System.out.println("날으는 닭의 이동거리= " + (cheatableChicken.getDistance()));
        }
    }
}
