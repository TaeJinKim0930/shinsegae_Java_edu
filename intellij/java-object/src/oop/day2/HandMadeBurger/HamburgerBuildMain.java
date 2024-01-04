package oop.day2.HandMadeBurger;

public class HamburgerBuildMain {
    public static void main(String[] args) {
        HamburgerBuild builder =
                new HamburgerBuild
                        .Builder(1,2)
                        .cheese(1)
                        .tomato(1)
                        .build();


        System.out.println(builder.toString(builder));



    }
}
