package oop.interface_quiz2.Bank1;

public class KBBank implements Bank {

    @Override
    public void withDraw(int price) {
        System.out.print("KB은행만의 인출 로직...");
        if (price < Bank.MAX_INTEGER) System.out.printf("%d 원을 인출한다.\n", price);
        else {
            System.out.println(price + "원 인출 실패");
        }
    }

    @Override
    public void deposit(int price) {
        System.out.printf("Kb은행만의 입금 로직...%d 원을 입금한다.\n", price);
    }
}
