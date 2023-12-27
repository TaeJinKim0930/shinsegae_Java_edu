package oop.day3;

public class MemberchainMain {
    public static void main(String[] args) {
        MemberChain mc = new MemberChain("이름", 1, "한국");
        System.out.println(mc.fn +  mc.age + mc.c);
    }
}
