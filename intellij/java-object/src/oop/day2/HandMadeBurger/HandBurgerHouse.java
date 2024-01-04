package oop.day2.HandMadeBurger;

public class HandBurgerHouse {
    public static void main(String[] args) {
        /**
         * // 점층적 생성자 패턴
         */
        // 모든 재료가 있는 햄버거
        Hamburger hamburger = new Hamburger(1,2,3,4,5,6);

        // 빵, 패티, 치즈
        Hamburger hamburger2 = new Hamburger(1,2,3);
        // 빵 패티, 치즈, 토마토
        Hamburger hamburger3 = new Hamburger(1,2,3,4);


        /**
         * JavaBean pattern 을 이용하여 햄버거 만들기
         */
        HamburgerBean hamburgerBean = new HamburgerBean();
        hamburgerBean.setBun(1);
        hamburgerBean.setPatty(1);
        hamburgerBean.setCheese(2);
    }
}
