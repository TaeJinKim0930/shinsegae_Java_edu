package oop.exception.exception3;

import java.util.Scanner;

public class IDFormatTest {
    static Scanner in = new Scanner(System.in);
    private String uid = null;


    public static void main(String[] args) {
        IDFormatTest test = new IDFormatTest();
        String userID = null;
        try {
            userID = in.next();
            test.setUid(userID);

        } catch ( IDFormatException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        } catch (Exception e) {
            System.out.println("예외 발생 예외 발생 사수는 응답하라 오바 인턴이 일을 저질렀다 오바");
        }
        System.out.println(test.getUid() + " 회원가입 완료");
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
}
