package oop.interface_quiz2.Bank1;

public class KakaoBank  {

    public void withDraw(int price) {
        System.out.printf("Kb은행만의 입금 로직...%d 원을 출금한다.\n", price);
    }


    public void deposit(int price) {
        System.out.printf("Kb은행만의 입금 로직...%d 원을 입금한다.\n", price);
    }


    public String findDormancyAccount(String custId) {
        System.out.println("**금융개정법안 오늘이후 고객의 휴면계좌 찾아주기 운동**");
        System.out.println("**금융결제원에서 제공하는 로직**");
        return "Kakao은행 123-456-7777-77";
    }
}
