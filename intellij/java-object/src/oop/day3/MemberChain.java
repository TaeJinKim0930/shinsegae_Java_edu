package oop.day3;

import java.lang.reflect.Member;

public class MemberChain {
    String fn;
    String c;
    int age;

    public MemberChain() {
        this("홍길순");
    }

    public MemberChain(String mName) {
        this(mName, 20);
    }

    public MemberChain(String mName, int mAge) {
        this(mName, mAge, "대한민국");
    }

    public MemberChain(String mName, int mAge, String mCountry) {
        fn = mName;
        age = mAge;
        c = mCountry;
    }
}
