package oop.day2.HandMadeBurger;

// JavaBean 패턴 : Setter
public class HamburgerBean {
    private int bun;
    private int patty;

    // 선택
    private int cheese;
    private int tomato;
    private int bacon;
    private int cabbage;
    private int pickle;

    public HamburgerBean() {}

    public void setBun(int bun) {
        this.bun = bun;
    }
    public void setPatty(int patty) {
        this.patty = patty;
    }
    public void setCheese(int cheese) {
        this.cheese = cheese;
    }
    public void setTomato(int tomato) {
        this.tomato = tomato;
    }
    public void setBacon(int bacon) {
        this.bacon = bacon;
    }
    public void setCabbage(int cabbage) {
        this.cabbage = cabbage;
    }
    public void setPickle(int pickle) {
        this.pickle = pickle;
    }
}



