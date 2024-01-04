package oop.interface_quiz2.Bank2;

/**
 * packageName : oop.isp.before
 * fileName : Duty
 * author :
 * date : 2023-12-27
 * description :객체지향 원칙 인터페이스 분리 원칙(Interface Segregation Principle)
 */
public enum Duty {
    PERSONAL_FINANCE("개인 금융 업무"),
    ENTERPRISE_FINANCE("기업 금융 업무"),
    PB("Private Banking 업무");

    private final String desc;

    Duty(String desc) {
        this.desc = desc;
    }

    public String description() {
        return this.desc;
    }
}
