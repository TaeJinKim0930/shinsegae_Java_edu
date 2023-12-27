package oop.day4.inher.test.다단계상속;

public class SubSon extends SubFather {
    private String son;

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public void printSon() {
        System.out.println("나는 " + getSon() + "입니다.");
        System.out.println("나는 " + getFather() + "로부터 상속 받습니다.");
        System.out.println("나의 " + getFather() + "는 프로그래머");
        printFather();
    }
}
