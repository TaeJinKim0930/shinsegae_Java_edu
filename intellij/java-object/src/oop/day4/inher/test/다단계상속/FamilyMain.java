package oop.day4.inher.test.다단계상속;

public class FamilyMain {
    public static void main(String[] args) {
        SubSon son = new SubSon();
        son.setGrandFather("할아버지");
        son.setFather("아버지");
        son.setSon("아들");
        son.setHouseAddress("인천");
        son.printSon();
    }
}
