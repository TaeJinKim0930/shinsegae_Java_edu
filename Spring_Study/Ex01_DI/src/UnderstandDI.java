import java.util.Date;

class Member {
    String name;
    String nickname;

    public Member() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

public class UnderstandDI {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }

    public static void getDate(Date d) {
        Date date = d;
        System.out.println(date);
    }

    /**
     * 생성자를 직접 호출해서 객체를 만들게 되면 강한 결합
     */
    public static void memberUser1(){
        // 강한 결합 : 직접 생성
        Member m1 = new Member();
    }

    /**
     * 의존할 객체를 주입 받아야 하니까, 메소드의 파라미터로 받아들여 객체에 할당
     */
    public static void memberUser2(Member m2) {
        // 약한 결합 : Setter
        Member m3 = m2;
    }


}
