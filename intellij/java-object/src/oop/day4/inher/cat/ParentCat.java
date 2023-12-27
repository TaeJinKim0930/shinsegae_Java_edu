package oop.day4.inher.cat;

public class ParentCat {
    private String breed;

    ParentCat() {}

    // Child 에서 super() 를 쓰기 위함.
    ParentCat(String breed) {
        this.breed = breed;
    }

    public void eat() {
        System.out.println("nyum nyum");
    }

    public String getBreed() {
        return breed;
    }
}
