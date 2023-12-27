package oop.interface_quiz2.Bank1;

public class SHBank implements Bank {


    @Override
    public void withDraw(int price) {
        System.out.printf("SH은행만의 인출 로직...%d 원을 인출한다.\n", price);
    }

    @Override
    public void deposit(int price) {
        System.out.printf("SH은행만의 입금 로직...%d 원을 입금한다.\n", price);
    }

}
