package oop.day4.inher.cat;

public class CatMain {
    public static void main(String[] args) {
        BabyCat bCat = new BabyCat("browns");

        bCat.eat();
        bCat.meow();

        bCat.printInfo();
        Object obj = bCat;
        // Object 타입을 BabyCat 타입으로 캐스팅
        BabyCat baby = (BabyCat) obj;

    }

}
