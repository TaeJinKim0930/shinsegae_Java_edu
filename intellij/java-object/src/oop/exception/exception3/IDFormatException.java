package oop.exception.exception3;

/**
 * 아이디가 null 이거나 지정범위를 벗어난 아이디가 입력되었을 경우 발생시키는 사용자 정의 예외클래스
 */
public class IDFormatException extends Exception{
    /**
     * 예외 상황: 메세지를 생성자에서 입력 받는다
     * Exception 클래스에서 메세지 생성자, 멤버변수, 메소드를 제공 받아서 예외 메세지를 설정함
     *  ㄴ  Exception(String message)
 *          Constructs a new exception with the specified detail message.
     */
    public IDFormatException(String msg) {
        super(msg);
    }
}
