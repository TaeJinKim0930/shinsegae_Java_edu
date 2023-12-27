package oop.day2.HandMadeBurger;

public class HamburgerBuild {
    private final int bun;
    private final int patty;

    private final int cheese;
    private final int tomato;

    public static class Builder {

        private final int bun;
        private final int patty;

        private int cheese;
        private int tomato;

        public Builder(int bun, int patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public Builder cheese(int val) {
            this.cheese = val;
            return this;
        }

        public Builder tomato(int val) {
            this.tomato = val;
            return this;
        }
        public HamburgerBuild build() {
            return new HamburgerBuild(this);
        }

        private void showBurger(Builder builder) {
            System.out.println(builder);
        }
    } // Builder


    private HamburgerBuild(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.tomato = builder.tomato;
    }


    public String toString(HamburgerBuild builder) {
        String result =
                "bun: "        + bun
                + "\nPatty: "  + patty
                + "\nCheese: " + cheese
                + "\nTomato: " + tomato
                ;

        return result;
    }

} // HamburgerBuild
