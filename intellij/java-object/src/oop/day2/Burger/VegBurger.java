package oop.day2.Burger;

public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Vegetable Burger";
    }

    @Override
    public float price() {
        return 10.5f;
    }
}
