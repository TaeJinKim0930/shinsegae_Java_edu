package oop.collection.list.vector;

import model.test.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorEx1 {

    public static void main(String[] args) {
        List<String> list1 = new Vector<>();
        List<String> list2 = new ArrayList<>();

        Thread threadA = new Thread() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    list1.add("hiho");
                }
            }
        };

        Thread threadB = new Thread() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    list1.add("I do not interrupt you");
                }
            }
        };

        Thread threadC = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    list2.add("hiho");
                }
            }
        };

        Thread threadD = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    list2.add("I interrupt you");
                }
            }
        };
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
            list1.forEach(System.out::println);
            list2.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
