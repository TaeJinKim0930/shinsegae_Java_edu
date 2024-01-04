package project.project1.shoppingList.entity;

import java.util.ArrayList;


public class Order {

    private ArrayList<Book> cartList;

    Order() {}

    public Order(ArrayList<Book> cartList) {
        this.cartList = cartList;
    }

    public void setCartList(ArrayList<Book> cartList) {
        this.cartList = cartList;
    }

    public ArrayList<Book> getCartList() {
        return cartList;
    }
}
