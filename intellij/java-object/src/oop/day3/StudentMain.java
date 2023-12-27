package oop.day3;

public class StudentMain {
    public static void main(String[] args) {
        Student stuObj1 = new Student();
        stuObj1.insertRecord(20021004, "홍길순");

        Student stuObj2 = new Student(20021005, "홍길동");
        stuObj2.printInfo();
    }
}
