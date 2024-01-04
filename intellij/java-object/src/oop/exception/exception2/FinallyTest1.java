/*
 * try 에서 number 와 number 2를 더하고 이 과정에서 문제가 생기면 catch 에서 잡아 내고
 * finally 부분에서는 무슨 상황이던 일단 number 와 number2 를 더한 값이 출력이 된다.
 */
package oop.exception.exception2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyTest1 {
    static void returnintFinally (int number, int number2) {
        // no? 나 works? 나 hio 가 출력이 안되는 이유는 main 에 있는 in.nextInt() 에서 InputMismatchException 이 일어나기 때문에
        // 이 method 가 호출되지 않아서 메인에 있는 finally 에 있는 gg는 출력이 되는데 이 method 에 있는 finally 는 출력이 되지 않음.
        int sum = 0;
        System.out.println("no?");
        try {
            sum = number + number2;
            System.out.println("works?");
            // Thrown to indicate that a method has been passed an illegal or inappropriate argument.
        } catch (  InputMismatchException e5) {
            e5.printStackTrace();
        } catch (ArithmeticException e1) {
            e1.printStackTrace();
        }  catch(IllegalArgumentException e4) {
            e4.printStackTrace();
            // 사실 divide 가 아니라 Arithmetic Exception은 필요업긴 함 ㅎ_ㅎ
            // InputMismatchException 은 integer 값에 String 값을 넣어 줄 경우에 에러가 난다
        }  catch (Exception e3) {
            e3.printStackTrace();
        } finally {
            System.out.println("hio");
//            System.out.println(sum);

        }
    }
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            returnintFinally(in.nextInt(), in.nextInt());
        } catch (InputMismatchException e1 ) {
            e1.printStackTrace();
        } finally {
            System.out.println("gg");
        }



    }
}