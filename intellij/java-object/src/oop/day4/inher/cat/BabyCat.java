package oop.day4.inher.cat;

public class BabyCat extends ParentCat {
    private String color;

    BabyCat() {

    }

    BabyCat(String color) {
        // 부모에 대한 생성자 호출. super 를 쓰려면 부모에서 하단에 있는 코드를 설정해줘야댐
//        ParentCat(String breed) {
//            this.breed = breed;
//        }
        super("샴");
        this.color = color;
    }

    public void meow() {
        System.out.println("meow meow");
    }

    public void printInfo() {
        System.out.println(getBreed());
        System.out.println(color);
    }
}
