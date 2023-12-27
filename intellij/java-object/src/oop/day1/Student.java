package oop.day1;

public class Student {
    public String name;
    public String major;

    // default constructor
    public Student() {}

    // Constructor Overloading : 메소드의 매개변수, 타입변경, 개수를 변경
    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public void study() {
        int studyE = 0;
        studyE++;
        System.out.println("학습 능력이 +1 상승했습니다: " + studyE);
    }

    public String eat(String food) {
//        study();
        return food + "(을)를 맛있게 냠냠! :)";
    }
}
