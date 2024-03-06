package book_pocket;

import book_pocket.service.ShoppingMallService;

import java.util.Scanner;

public class ShoppingMallServiceRunner {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        ShoppingMallService shoppingMallService = new ShoppingMallService(sc);
        while (true) {
            if (!shoppingMallService.displayMenuAndGetIsContinue()) {
                break;
            }
        }
        sc.close();
    }
}