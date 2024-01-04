package oop.day4.inher.test;
// 여러개의 파일 말고 하나의 파일에 보기 쉽게 몰아 넣음.

    class A {
        private int numberA;
        A(){}

        public int getNumberA() {
            return numberA;
        }
        public void printNumberA() {
            System.out.println(getNumberA());
        }
    }

    // 자식 : B, 부모 : A
    class B extends A {
        private int numberB;

        B(){
            printNumberB();
        }

        public int getNumberB() {
            return numberB;
        }
        public void setNumberB(int numberB) {
            this.numberB = numberB;
        }
        public void printNumberB() {
            System.out.println(getNumberB());
        }

    }

    class C extends B {
        private int numberC;

        public int getNumberC() {
            return numberC;
        }

        public void printNumberC() {
            System.out.println(getNumberC());
        }
    }

    class D extends C {
        private int numberD;

        public int getNumberD() {
            return numberD;
        }

        public void printNumberD() {
            System.out.println(getNumberD());
        }

        public void getAllInfo() {
            super.printNumberA();
            super.printNumberB();
            super.printNumberC();

//           this.getNumberD(); or
             printNumberD();
        }
    }


public class ABCDMain {
    public static void main(String[] args) {
        /**
         * B(A()) 이런 느낌이라서 B는 A를 다 쓸 수 있음.
         */
        System.out.println("-------------------------");
        B b = new B();
        b.getNumberB();
        b.getNumberA();
        b.printNumberB();
        b.printNumberA();

        /**
         * 부모(A)는 자식(B)을 담을 수 있는 타입이 아님
         * 부모가 먼저 생성이 되기 때문에 B(A()) 이런 느낌으로 생성이 되서
         * B는 A를 쓸 수 있고 A 는 B를 쓸 수가 없음
         */
        System.out.println("-------------------------");
        A a = new B();
        a.getNumberA();
        a.printNumberA();

        System.out.println("-------------------------");
        D d = new D();
        d.getAllInfo();
    }
}
