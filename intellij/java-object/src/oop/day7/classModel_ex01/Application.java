package oop.day7.classModel_ex01;

import model.test.A;

public class Application {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.deposit(10000);

        Account account2 = new Account("1234", " 신세카이", "1234");
        
    }
}
