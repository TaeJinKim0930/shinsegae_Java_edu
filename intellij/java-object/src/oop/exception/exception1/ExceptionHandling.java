package oop.exception.exception1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 실습 1.
 * 요소가 5개인 정수형 배열을 만들고,
 * 요소에 0 ~ 4를 대입하는 코드
 * 배열 크기가 5이므로 정수 값을 5개 저장할 수 있다 (예외처리)
 * 6개의 요소를 입력하여 발생하는 에러를 학인해 주세요.
 */
public class ExceptionHandling {

    public static void fileInput() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/oop/exception/exception1/data.txt");
            System.out.println("파일 읽었덩");
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일 없덩");
            fnfe.printStackTrace();
        } finally {
            // 여기서 close() 을 할 때도 문제가 생길 수 있기 때문에 try catch 를 한번 더 입혀줍니다.
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("finally 문은 항상 수행");
        }
        System.out.println("예외 처리 후 수행");
    }

    public static void main(String[] args) {
        fileInput();
    }
}
