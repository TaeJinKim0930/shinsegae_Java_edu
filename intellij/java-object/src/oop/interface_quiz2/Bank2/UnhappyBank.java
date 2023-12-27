package oop.interface_quiz2.Bank2;

/**
 * packageName : oop.isp.before
 * fileName : BBAnk
 * author :
 * date : 2023-12-27
 * description : 객체지향 원칙 인터페이스 분리 원칙(Interface Segregation Principle)
 */
public class UnhappyBank implements PF {

    @Override
    public void doPersonalFinance() {
        System.out.println(this.msg(this.getClass().getSimpleName(), Duty.PERSONAL_FINANCE));
    }
}
