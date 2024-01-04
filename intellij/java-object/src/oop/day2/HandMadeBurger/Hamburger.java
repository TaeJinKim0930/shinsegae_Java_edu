package oop.day2.HandMadeBurger;

// 점층적 생성자 패턴
public class Hamburger {
    // 필수
    private int bun;
    private int patty;

    // 선택
    private int cheese;
    private int tomato;
    private int bacon;
    private int cabbage;
    private int pickle;

    public Hamburger() {}

    public Hamburger(int bun, int patty, int cheese, int tomato, int bacon, int cabbage, int pickle) {
        // heap 영역에서 주소값을 가지고 있는 instance 된 객체의 주소값을 this 라는 keyword 에 저장 하는 것
        // 생성이 되는 순간 날라가기 때문에 안전한 위치인 heap 에 안전하게 저장을 한 것
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
        this.bacon = bacon;
        this.cabbage = cabbage;
        this.pickle = pickle;
    }

    public Hamburger(int bun, int patty, int cheese) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
    }

    public Hamburger(int bun, int patty, int cheese, int tomato) {
        // heap 영역에서 주소값을 가지고 있는 instance 된 객체의 주소값을 this 라는 keyword 에 저장 하는 것
        // 생성이 되는 순간 날라가기 때문에 안전한 위치인 heap 에 안전하게 저장을 한 것
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
    }

    public Hamburger(int bun, int patty, int cheese, int tomato, int bacon) {
        // heap 영역에서 주소값을 가지고 있는 instance 된 객체의 주소값을 this 라는 keyword 에 저장 하는 것
        // 생성이 되는 순간 날라가기 때문에 안전한 위치인 heap 에 안전하게 저장을 한 것
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
        this.bacon = bacon;
    }

    public Hamburger(int bun, int patty, int cheese, int tomato, int bacon, int cabbage) {
        // heap 영역에서 주소값을 가지고 있는 instance 된 객체의 주소값을 this 라는 keyword 에 저장 하는 것
        // 생성이 되는 순간 날라가기 때문에 안전한 위치인 heap 에 안전하게 저장을 한 것
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
        this.bacon = bacon;
        this.cabbage = cabbage;
    }

}
