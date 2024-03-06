package oop.day3.shopingList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. User Object 에서 User 정보 불러오기
 * 2. Book[] bookArr 리스트를 for 돌려서 다 불러오기
 * 3. Book[] bookArr 배열을 싹다 지워줘서 삭제하기
 * 4. Book[] bookList 다 출력하고 + 입력 받은 Book ID를 bookArr 배열에 하나 추가하기
 * 5. Book[] bookArr 배열에 있는 quantity -num
 * 6. Book[] bookArr 배열에 있는 bookNo 책의 데아터를 삭제
 * 7. Book[] bookArr 에서 bookNo, title, price, quantity;
 * 8. System.exit(0)
 */
public class ShoppingMallMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 책 리스트를 넣어주는 책 리스트
        Book[] bookList = new Book[3];
        // 유저를 생성합니다
        User user = new User();
        // Book 배열의 값은 임의로 30으로 정했습니다.
        Book[] bookArr = new Book[30];
//        Order order = new Order();

        // Book 에 있는 메소드들을 사용하기 위해 만들어줬습니다.
        // Book 에 있는 메소드들은 return 값이 없거나 배열 혹은 book 값을 변경하는 메소드가 없어서 임의로 만들고 사용했습니다.
        Book bookfunc = new Book.Builder().build();
        UserService userService = new UserService();

        // BookList 에 책의 값들을 Builder 를 사용하여 넣어줍니다.
        bookList[0] = new Book
                .Builder()
                .bookNo("ISBN1234")
                .price(27000)
                .title("단계별로 쇼핑몰을 구현하여 배우는 JSP 웹 프로그래밍")
                .subject("쉽게 배우는 JSP 웹 프로그래밍")
                .author("송미영")
                .category("IT전문서")
                .date("2022/09/30")
                .build();

        bookList[1] = new Book
                .Builder()
                .bookNo("ISBN1235")
                .price(33000)
                .title("실습 단계별 명쾌한 멘토링!")
                .subject("안드로이드 프로그래밍")
                .author("우재남")
                .category("IT전문서")
                .date("2022/01/22")
                .build();

        bookList[2] = new Book
                .Builder()
                .bookNo("ISBN1236")
                .price(20000)
                .title("컴퓨팅 사고력을 키우는 블록 코딩")
                .subject("스크래치")
                .author("고광일")
                .category("컴퓨터입문")
                .date("2022/06/10")
                .build();


        System.out.print("당신의 이름을 입력하세요 : ");
        user.setName(in.nextLine());
        System.out.print("\n연락처를 입력하세요 : ");
        user.setContact(in.nextLine());
        System.out.println();

        while (true) {
            System.out.println("*******************************************");
            System.out.println("          Welcome to Shopping Mall");
            System.out.println("          Welcome to Book Market!");
            System.out.println("*******************************************");
            System.out.println("1. 고객 정보 확인하기          4. 바구니에 항목 추가하기");
            System.out.println("2. 장바구니 상품 목록 보기      5. 장바구니의 항목 수량 줄이기");
            System.out.println("3. 장바구니 비우기             6. 장바구니의 항목 삭제하기");
            System.out.println("7. 영수증 표시하기             8. 종료");
            System.out.println("9. 관리자 아이디 로그인");

            int num = -1;
            System.out.println("메뉴 번호를 선택해주세요 ");
            num = in.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.printf("고객님의 성함은   : %s 입니다\n", user.getName());
                    System.out.printf("고객님의 연락처는 : %s 입니다\n", user.getContact());
                }
                case 2 -> {
                    /**
                     * bookArr 배열이 비어있으면 장바구니가 비었다는 문구가 뜨고
                     * 값이 존재 한다면 isNotEmpty(Book[]) 에서 null 값과 N/A 값을 필터링 한 후의 값을 불러와 출력합니다.
                     */
                    if(bookfunc.isNotEmpty(bookArr)) {
                        System.out.println("고객님의 장바구니 상품 목록 입니다");
                        bookfunc.printArrList(bookArr);
                    } else {
                        System.out.println("장바구니가 비었습니다. 상품을 먼저 장바구니에 담아주세요.");
                    }
                }
                case 3 -> {
                    // null 값으로 전부 채워줘서 장바구니를 비워줍니다
                    Arrays.fill(bookArr, null);
                    System.out.println("장바구니를 비웠습니다");
                }
                case 4 -> {
                    // 바구니에 항목 추가하기 앞서 책 리스트들을 불러옵니다.
                    bookfunc.printArrList(bookList);

                    System.out.print("장바구니에 추가할 도서의 ID를 입력하세요: ");
                    String isbn = in.next();

                    /**
                     * BookArr 배열에 Book 의 값을 넣어줍니다.\
                     * 만약 유저가 입력한 Book 이름(ISBN) 값이 bookList 배열에 존재 할경우에만 값을 넣어줍니다.
                     * Y/N 값을 받을 시 소문자로 입력을 할 수 있기에 toUpperCase() 로 다 대문자화를 시켜줍니다.
                     * 그리고 유저가 장바구니에 넣겠다(Y값) 라고 입력을 하였을 경우 bookArr 배열에 null 값(빈곳)을 찾아서
                     * 해당 book 값을 넣어주고 quantity(수량) 애 1개를 넣어 주고 break 로 bookArr 배열 for loop 을 탈출합니다.
                     */
                    Arrays.stream(bookList).forEach(book -> {
                        if (book.bookNo.equals(isbn)) {
                            System.out.printf("\n 장바구니에 추가하겠습니까? Y | N ");
                            String saveBook = in.next();
                            saveBook.toUpperCase();

                            if (saveBook.equals("Y")) {
                                for (int j = 0; j < bookArr.length; j++) {
                                    if (bookArr[j] == null) {
                                        bookArr[j] = book;
                                        bookArr[j].quantity = 1;
                                        break;
                                    }
                                }
                            }
                        }
                    });
                }
                case 5 -> {
                    System.out.print("수량을 줄이고자 하는 책의 ID를 입력해주세요 : ");
                    String isbnToDecrease = in.next();
                    System.out.println();

                    /**
                     * 만약 bookArr 값이 있을경우에만 수량 줄이고 싶은 Book ID(ISBN) 유저에게 받은 값을 가지고 bookArr 배열에서 찾은 후
                     * 해당 book 의 quantity 수를 1개 내려주고 해당 책의 이름과 수량을 출력합니다.
                     * 이때 수량의 값이 1일 경우에는 하단 출력문을 출력해줍니다.
                     * 책의 이름을 잘못 입력 시, 해당 책의 이름이 존재하지 않는다는 문구가 뜹니다.
                     */
                    if(bookfunc.isNotEmpty(bookArr)) {
                        Arrays.stream(bookArr).forEach(book -> {
                            if (book.bookNo.equals(isbnToDecrease)) {
                                if (book.quantity == 1) {
                                    System.out.println("\n책의 수량이 1입니다. 책을 리스트에서 지우시려면 6번을 선택해주세요");
                                } else if (book.quantity > 1) {
                                    book.quantity -= 1;
                                    System.out.printf("\n%s 책의 남은 수량 입니다: %d\n",book.title, book.quantity);
                                }
                            }
                        });
                    } else {
                        System.out.printf("수량을 줄이고자 하시는 책 \"%s\" 이 존재하지 않습니다\n", isbnToDecrease);
                    }

                }
                case 6 -> {
                    // deleteTheBook 메소드를 사용하여 원하는 book 배열에 원하는 book ID 값을 입력하여 해당 값을 삭제해줍니다.
                    System.out.print("삭제하고자 하는 항목의 책 ID 를 입력해주세요: ");
                    String isbnToDelete = in.next();
                    bookfunc.deleteTheBook(bookArr, isbnToDelete);
                }
                case 7 -> {
                    // 영수증을 출력
                    System.out.println("영수증을 출력합니다");
                    bookfunc.printArrReceipt(bookArr);
                }
                case 8 -> {
                    // 시스템 종료
                    System.out.println("시스템을 종료합니다.");
                    System.exit(0);
                }
                case 9 -> {
                    userService.insertAdminId();
                    userService.checkAdminAccount(user);
                }
                default -> {
                    // 잘못된 값이 입력이 될 경우
                    System.out.println("잘못된 값입니다 다시 입력해주세요");
                }
            }
        }


    }
}
