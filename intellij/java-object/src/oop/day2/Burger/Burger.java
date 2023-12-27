package oop.day2.Burger;

public abstract class Burger implements Item {
    public Packing packing() { return new Wrapper(); }

    public abstract float price();
}
