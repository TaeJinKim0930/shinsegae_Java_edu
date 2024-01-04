package oop.day1;

public class PersonMain {
    public static void main(String[] args) {
//        Person person = new Person("TJ", 19, "Seoul", "010-2122-8150");
//        person.personInformation();

        Person person =
                new Person
                        .Builder("TJ", 23)
                        .address("hiho")
                        .phoneNumber("010-2122-8150")
                        .build();
    }
}
