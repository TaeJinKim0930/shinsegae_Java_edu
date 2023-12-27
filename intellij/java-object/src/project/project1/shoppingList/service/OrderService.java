package project.project1.shoppingList.service;

import project.project1.shoppingList.entity.Book;
import project.project1.shoppingList.entity.Order;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class OrderService {
    private BookService bookService = new BookService();
    Order order;
    private ArrayList<Book> cartLists = new ArrayList<>();

    private UserService userService = UserService.getInstance();

    public ArrayList<Book> getCartLists() {
        return cartLists;
    }

    public void addToOrder(Book book) {
        cartLists.add(book);
    }

    public void printOrderList(ArrayList<Book> cartList) {
        try {
            if (userService.getUser() != null)
                System.out.println(userService.getUser() + " Cart List");
            bookService.printBookList(cartList);
        } catch (NullPointerException npe) {
            System.out.println("장바구니가 비었습니다");
//            System.out.println(npe.toString());
        }

    }

    public void deleteTheBookWithISBN(String isbn) {
        try {

            cartLists.remove(bookService.getTheBookWithISBN(isbn));
            System.out.printf("%s 책이 장바구니에서 삭제되었습니다.", isbn);
        } catch (NullPointerException npe) {
            System.out.printf("이름이 %s 인 책을 찾을수 없습니다.\n", isbn);
            System.out.println(npe.toString());
            throw npe;
        } catch (Exception e) {
            System.out.println("원인이 뭔지 찾아보세요");
            System.out.println(e.toString());
        }
    }

    public void addBookToList(String isbn) {
        try {
//            System.out.println(bookService.getTheBookWithISBN(isbn));

            cartLists.add(bookService.getTheBookWithISBN(isbn));

            printOrderList(cartLists);
        } catch (NullPointerException npe) {
            System.out.println("카트가 비어있습니다.");
            System.out.println(npe.toString());
        } catch (InputMismatchException ime) {
            System.out.println("잘못된 값입니다. 장바구니에 값을 넣는대에 실패했습니다.");
            System.out.println(ime.toString());
        } catch (Exception e) {
            System.out.printf("입력하신 %s 책이 존재하지 않습니다. 다시 시도해주세요\n", isbn);
            System.out.println(e.toString());
        }

    }
}
