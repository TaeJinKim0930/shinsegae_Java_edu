package oop.interface_quiz2.Bank2;

/**
 * packageName : isp.domain
 * fileName : ABank
 * author :
 * date : 2023-12-27
 * description : 객체지향 원칙 인터페이스 분리 원칙(Interface Segregation Principle)
 */
public class HappyBank implements EF, PB {
    @Override
    public void doEnterpriseFinance() {
        System.out.println(this.msg(this.getClass().getSimpleName(), Duty.ENTERPRISE_FINANCE));
    }

    @Override
    public void doPrivateBanking() {
        System.out.println(this.msg(this.getClass().getSimpleName(), Duty.PB));
    }
}