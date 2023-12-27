package oop.day1;

public class Person {
    public final String name;
    public final int age;
    public final String address;
    public final String phoneNumber;

    public void personInformation() {
        System.out.printf("%s의 나이는 %d살이고 주소는 %s이며 전화번호는 %s", name, age, address, phoneNumber);
    }

    public static class Builder {
        private final String name; // 필수
        private final int age; // 필수
        private String address;
        private String phoneNumber;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        address = builder.address;
        phoneNumber = builder.phoneNumber;
    }

}
