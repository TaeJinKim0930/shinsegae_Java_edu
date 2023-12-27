package oop.day7.classModel_ex01;

public class Account {
    private int balance;

    private String accNo;

    private String name;
    private String pw;
    Account() {}

    Account(String accNo, String name, String pw) {
        this.accNo = accNo;
        this.name = name;
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int deposit(int money) {
        System.out.println("Your amount of deposit is :" + money);
        System.out.println("Deposit processing");
        this.balance += money;
        printBalance();
        return this.balance;
    }

    public void printBalance() {
        System.out.println("Your balance is : " + balance);
    }

}

