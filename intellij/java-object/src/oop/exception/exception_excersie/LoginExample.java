package oop.exception.exception_excersie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginExample {
    private String id = "tjmax";
    private String pw = "1004";
    static Scanner in = new Scanner(System.in);

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public boolean compareID(String inputId) throws NotExitIDWrongPasswordException {
        boolean wan = false;
        if (inputId == null) {
            throw new NotExitIDWrongPasswordException("입력하신 아이디 값이 없습니다 null :(");
        } else if (inputId.equals(getId())){
            System.out.println("아이디 비교 -완-");
            wan = true;
        }
        return wan;

    }

    public boolean comparePw(String inputPw) throws NotExitIDWrongPasswordException {
        boolean wan = false;
        if (inputPw == null) {
            throw new NotExitIDWrongPasswordException("입력하신 비밀번호 값이 없습니다 null :(");
        } else if (inputPw.equals(getPw())){
            System.out.println("비밀번호 비교 -완-");
            wan = true;
        }
        return wan;
    }

    public static void main(String[] args) {
            LoginExample loginExample = new LoginExample();
            String inputID = null;
            String inputPW = null;

            try {
                inputID =  in.next();
                inputPW =  in.next();
                if (loginExample.compareID(inputID) && loginExample.comparePw(inputPW)) {
                    System.out.println("로그인 완료");
                } else {
                    System.out.println("로그인 실패");
                }
            } catch (NotExitIDWrongPasswordException e) {
                System.out.println(e.toString());
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            } catch (InputMismatchException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

    }
}
