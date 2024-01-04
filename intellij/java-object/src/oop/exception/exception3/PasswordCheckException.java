package oop.exception.exception3;

/**
 * 예외상황은 비밀번호가 null
 * 문자열로만 이루어진 경우 ==> String 의 match() 메소드 사용
 * 문자열은 영문자, 숫자로 제한
 * 5자 이하인 경우
 *
 */
public class PasswordCheckException extends Exception {
    PasswordCheckException(String msg) {
        super(msg);
    }
}
