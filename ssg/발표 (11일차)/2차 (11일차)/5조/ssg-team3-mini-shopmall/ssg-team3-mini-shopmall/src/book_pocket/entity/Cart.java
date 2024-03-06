package book_pocket.entity;

import java.util.List;

public class Cart {
    private List<Book> listCart;

    public void addToCart(Book book) {
        listCart.add(book);
    }
}
