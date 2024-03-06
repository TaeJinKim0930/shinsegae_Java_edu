package book_pocket.service;

import book_pocket.entity.User;

import java.util.Scanner;

public class ShoppingMallService {
    String[] menus = {"고객 정보 확인하기", "장바구니 상품 목록 보기", "장바구니 비우기", "바구니에 항목 추가하기", "장바구니의 항목 수량 줄이기", "장바구니의 항목 삭제하기", "영수증 표시하기", "종료", "관리자 로그인"};
    private UserService userService;
    private OrderService orderService;

    private AdminService adminService;
    private Scanner sc;

    public ShoppingMallService(Scanner sc) {
        this.sc = sc;
        userService = new UserService(getUser());
        orderService = new OrderService(sc, userService);
        adminService = new AdminService(sc);
        displayGreeting();
    }

    private User getUser() {
        System.out.print("당신의 이름을 입력하세요 : ");
        String nameUser = sc.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phoneUser = sc.nextLine();
        return new User(nameUser, phoneUser);
    }

    private void displayGreeting() {
        System.out.println("*".repeat(54));
        System.out.print(" ".repeat(8));
        System.out.print("Welcome to Shopping Mall");
        System.out.print(" ".repeat(8));
        System.out.println();
        System.out.print(" ".repeat(8));
        System.out.print("Welcome to Book Market!");
        System.out.print(" ".repeat(8));
        System.out.println();
        System.out.println("*".repeat(54));
    }

    public boolean displayMenuAndGetIsContinue() {
        int lenMenus = menus.length;
        for (int idxMenu = 0; idxMenu < lenMenus; idxMenu++) {
            System.out.printf("%d. %s", (idxMenu + 1), menus[idxMenu]);
            System.out.println();
        }
        System.out.println("*".repeat(54));
        String cmd = sc.nextLine();
        System.out.println("*".repeat(54));
        switch (cmd) {
            case "1" -> userService.displayUser();
            case "2" -> orderService.getCartProductList();
            case "3" -> orderService.resetCart();
            case "4" -> {
                System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
                String bookIdForAdd = sc.nextLine();
                System.out.println("장바구니에 추가하겠습니까? Y | N");
                String flag = sc.nextLine();
                if (flag.equals("Y")) {
                    orderService.addCart(bookIdForAdd);
                }
            }
            case "5" -> {
                System.out.print("장바구니에 수량을 감소시킬 도서의 ID를 입력하세요 :");
                String bookIdForDecrease = sc.nextLine();
                orderService.decreaseAmount(bookIdForDecrease);
            }
            case "6" -> {
                System.out.print("장바구니에 수량을 초기화할 도서의 ID를 입력하세요 :");
                String bookIdForDelete = sc.nextLine();
                orderService.deleteCartProduct(bookIdForDelete);
            }
            case "7" -> orderService.showReceipt();
            case "8" -> {
                return false;
            }
            case "9" -> {
                System.out.println("관리자 정보를 입력하세요");
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                System.out.print("비밀번호 : ");
                String password = sc.nextLine();
                adminService.authenticate(userService.getUser(), id, password);
            }
            default -> System.out.println("1부터 9까지의 숫자를 입력하세요");
        }
        System.out.println("*".repeat(54));
        System.out.println("메뉴 번호를 선택해주세요 ");
        System.out.println("*".repeat(54));
        return true;
    }
}