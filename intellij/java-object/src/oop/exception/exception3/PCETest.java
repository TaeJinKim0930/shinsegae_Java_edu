package oop.exception.exception3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PCETest {
    static Scanner in = new Scanner(System.in);
    private String password = null;
    private String uid = null;

    public void setPassword(String password) throws PasswordCheckException {
        String regex = "^[a-zA-Z0-9]*$";
        System.out.println("set ready");
        if (password.isBlank()) {
            throw new PasswordCheckException("패스워드가 비었습니다");
        } else if (password.length() > 5) {
            throw new PasswordCheckException("패스워드는 5자 이하만 가능 합니다.");
        } else if (!password.matches(regex)) {
            throw new PasswordCheckException("패스워드는 영어와 숫자만 쓸 수 있습니다.");
        } else {
            System.out.println("패스워드 입력 -완-");
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) throws IDFormatException {
        if (uid == null) {
            throw new IDFormatException("아이디는 null null 해유");
        } else if(uid.length() < 8 || uid.length() > 20) {
            throw new IDFormatException("아이디는 8 ~ 20 자리수 입니당");
        } else {
            this.uid = uid;
        }
    }

    public static void main(String[] args) {

        IDFormatTest test = new IDFormatTest();
        String userID = null;
        PCETest pceTest = new PCETest();
        String temp = null;

        try {
            System.out.println("8자 ~ 20자의 아이디를 입력해주세요.");
            userID = in.next();
            test.setUid(userID);
            System.out.println("5자 이하의 패스워드를 입력해주세요.");
            temp = in.next();
            pceTest.setPassword(temp);
        } catch (IDFormatException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        } catch (PasswordCheckException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        } catch (InputMismatchException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            System.out.println("예외 발생 예외 발생 사수는 응답하라 오바 인턴이 일을 저질렀다 오바");
        }
        System.out.println(test.getUid() + " 회원가입 완료");
        System.out.println("패스워드 : " + pceTest.getPassword());

    }
}
