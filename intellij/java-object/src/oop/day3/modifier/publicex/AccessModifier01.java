package oop.day3.modifier.publicex;

public class AccessModifier01 {
    public static void main(String[] args) {
        Dog dogObj1 = new Dog();
        dogObj1.breed = "ㅍㅁ";
        dogObj1.color = "white";
        System.out.println(dogObj1.breed + " " + dogObj1.color);
    }
}
