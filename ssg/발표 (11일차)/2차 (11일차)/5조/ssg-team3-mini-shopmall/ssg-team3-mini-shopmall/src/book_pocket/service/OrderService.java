package book_pocket.service;

import book_pocket.entity.Book;

import java.util.Scanner;

public class OrderService {

    private Scanner sc;
    private UserService userService;
    private BookService bookService = new BookService();

    private int[] cartAmount = new int[bookService.getLengthBooks()];

    public OrderService(Scanner sc, UserService us) {
        this.sc = sc;
        this.userService = us;
    }

    public void resetCart() {
        cartAmount = new int[bookService.getLengthBooks()];
        System.out.println("장바구니가 초기화되었습니다.");
    }

    public void addCart(String bookId) {
        boolean isExist = false;
        for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = bookService.getBookById(idxCart);
            if (el.getIsbn().equals(bookId)) {
                cartAmount[idxCart]++;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.printf("%s 도서가 장바구니에 추가되었습니다.", bookId);
            System.out.println();
        } else {
            System.out.println("존재하지 않는 도서입니다.");
        }
    }

    public void decreaseAmount(String bookId) {
        int amountRemain = -1;
        for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = bookService.getBookById(idxCart);
            if (el.getIsbn().equals(bookId)) {
                cartAmount[idxCart] = cartAmount[idxCart] < 1 ? 0 : cartAmount[idxCart] - 1;
                amountRemain = cartAmount[idxCart];
                break;
            }
        }
        if (amountRemain != -1) {
            System.out.printf("장바구니 내 %s 도서의 현재 수량은 %d 권입니다", bookId, amountRemain);
            System.out.println();
        } else {
            System.out.println("해당 도서는 장바구니에 존재하지 않습니다.");
        }
    }

    public void deleteCartProduct(String bookId) {
        boolean isExist = false;
        for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = bookService.getBookById(idxCart);
            if (el.getIsbn().equals(bookId)) {
                isExist = true;
                cartAmount[idxCart] = 0;
            }
        }
        if (isExist) {
            System.out.printf("장바구니 내 %s 도서의 수량이 초기화되었습니다.", bookId);
            System.out.println();
        } else {
            System.out.println("해당 도서는 장바구니에 존재하지 않습니다.");
        }
    }

    public void getCartProductList() {
        boolean isEmpty = true;
        int lenCartAmount = cartAmount.length;
        for (int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            Book el = bookService.getBookById(idxCart);
            if (cartAmount[idxCart] > 0) {
                isEmpty = false;
                System.out.printf("장바구니에 담긴 %s 도서의 총 수량은 %d입니다.", el.getIsbn(), cartAmount[idxCart]);
                System.out.println();
            }
        }
        if (isEmpty) {
            System.out.println("장바구니가 비어 있습니다.");
        }
    }

    public void showReceipt() {
        int lenCartAmount = cartAmount.length;
        for (int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            if (cartAmount[idxCart] > 0) {
                Book el = bookService.getBookById(idxCart);
                System.out.println(el + " " + cartAmount[idxCart] + "권 |");
            }
        }
    }
}