package oop.exception.exception2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowableException {
    private Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }


    public static void main(String[] args) {
        ThrowableException test = new ThrowableException();
        try {
            test.loadClass("src/oop/exception/exception1/data.txt", "java.lang.String");

        } catch (FileNotFoundException | ClassNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
