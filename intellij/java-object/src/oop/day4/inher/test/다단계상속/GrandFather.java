package oop.day4.inher.test.다단계상속;

public class GrandFather {
    private String grandFather;
    GrandFather() {}

    public String getGrandFather() {
        return grandFather;
    }

    public void setGrandFather(String grandFather) {
        this.grandFather = grandFather;
    }

    public void printGrandFather() {
        System.out.println("나는 " + getGrandFather() + "입니다.");
    }
}
