package oop.day2.Burger;

public class Wrapper implements Packing {

    // 재정의, 실체화
    @Override
    public String pack() {
        return "Wrapper";
    }
}
