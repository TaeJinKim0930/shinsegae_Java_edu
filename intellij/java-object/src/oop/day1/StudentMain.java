package oop.day1;

public class StudentMain {
    public static void main(String[] args) {
        // default 생성자(constructor)
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student("TJ", "CS");

        s1.name = "홍길동";
        s1.major = "CS";

        s2.name = "김태진";
        s2.major = "Computer Science";

        s1.study();
        String eat = s1.eat("짜장면");
//        System.out.println(s1.name + " 학생이 " + eat + "먹었다");


    }
}
