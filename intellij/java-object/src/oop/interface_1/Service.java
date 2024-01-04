package oop.interface_1;

public interface Service {
    // default method
    default void defaultExampleMethodA() {
        System.out.println("default method A");
        defaultExampleCommon();
    }

    default void defaultExampleMethodB() {
        System.out.println("default methodB");
        defaultExampleCommon();
    }
    // 5-1. private 메소드
    private void defaultExampleCommon() {
        System.out.println("defaultMethod의 중복코드 A");
        System.out.println("defaultMethod의 중복코드 B");
    }

    // 5-2. static(정적) 메소드
    static void staticExampleMethodA() {
        System.out.println("staticMethod의 종속코드A ");
        staticExampleCommon();
    }

    static void staticExampleMethodB() {
        System.out.println("staticMethod의 종속코드B ");
        staticExampleCommon();
    }

    // 5-2. private static(정적) 메소드
    private static void staticExampleCommon() {
        System.out.println("staticMethod 중복 코드");
    }

}
