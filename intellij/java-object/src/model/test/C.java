package model.test;

public class C {
    public static void main(String[] args)  {
        A s1 = new A();
        A s2 = new A();
        A s3 = new A();

        B x1 = new B();
        B x2 = new B();
        B x3 = new B();

//        s1.a1();
//        x1.b1();

//        x1.b3(s1.a3());
//        String data = s1.a3();
//        x1.b3(data);

        String printAB = x1.b4(s1.a3());
        System.out.println(printAB);
    }
}