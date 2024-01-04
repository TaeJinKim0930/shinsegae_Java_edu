package oop.interface_quiz2.Bank2;

/**
 * packageName : isp
 * fileName : Bank
 * author : TJ
 * date : 2023-12-27
 * description : 객체지향 원칙 인터페이스 분리 원칙(Interface Segregation Principle)
 *                클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다 라는 원칙이다.
 *                어떠한 인터페이스가 서로 다른 메서드를 사용하는 클라이언트가 사용한다면 좋은 설계가 아니다.
 *                인터페이스의 변화에 따라 모든 클라이언트에 영향을 줄 수 있기 때문에
 *                사용 기능에 따라 인터페이스를 분리하는 것이 내부 의존도를 낮출 수 있고,
 *                구현 클래스가 관심있는 메소드에 대해서만 관심을 가질 수 있다.
 */
public interface Bank {
    default String msg(String bankName, Duty duty) {
        return String.format("%s는 %s를 합니다.", bankName, duty.description());
    }

}
