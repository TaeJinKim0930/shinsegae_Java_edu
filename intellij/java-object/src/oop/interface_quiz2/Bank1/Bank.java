package oop.interface_quiz2.Bank1;

public interface Bank {
    //상수 (최대 고객에게 인출해 줄 수 있는 금액 명시)
    public int MAX_INTEGER = 10000000;

    //추상메소드(인출하는 메소드)
    void withDraw(int price);

    //추상메소드(입금하는 메소드)
    void deposit(int price);

    //defualt 메소드(고객의 휴면계좌 찾아주는 메소드 : 필수구현은 선택사항)
    default String findDormancyAccount(String custId) {
        String bankNameToFind = "";
        if (custId.length() == 6) {
            bankNameToFind = "KB";
            System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
            System.out.println("**금융결제원에서 제공하는 로직**");
        }
        else if (custId.length() == 4) {
            System.out.println("SH은행은 별도의 후행처리 작업을 따로 한다.");
            bankNameToFind = "SH";
            System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
            System.out.println("**SH은행만의 로직 적용**");
        }
        return bankNameToFind + "은행 000-000-0000-00";
    }

    //정적 메소드(블록체인 인증을 요청하는 메소드)
    static void BCAuth(String bankName) {
        System.out.println(bankName + " 에서 블록체인 인증을 요청합니다.");
        System.out.println("전 금융사 공통 블록체인 로직 수행");
    }


}
