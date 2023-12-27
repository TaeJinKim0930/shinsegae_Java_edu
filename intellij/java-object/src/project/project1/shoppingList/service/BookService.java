package project.project1.shoppingList.service;

import project.project1.shoppingList.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    // 맨 처음에 주어지는 4개의 책의 정보를 담은 List 입니다.
    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public BookService() {
        // BookService 가 호출이 되는 순간 책의 정보를 넣어줍니다.
        createBookList();
    }

    // BookList 에 책의 값들을 Builder 를 사용하여 넣어줍니다.
    public void createBookList() {
        bookList.add(new Book
                .Builder()
                .bookNo("ISBN1234")
                .price(27000)
                .title("단계별로 쇼핑몰을 구현하여 배우는 JSP 웹 프로그래밍")
                .subject("쉽게 배우는 JSP 웹 프로그래밍")
                .author("송미영")
                .category("IT전문서")
                .date("2022/09/30")
                .build()
        );
        bookList.add(
                new Book
                        .Builder()
                        .bookNo("ISBN1235")
                        .price(33000)
                        .title("실습 단계별 명쾌한 멘토링!")
                        .subject("안드로이드 프로그래밍")
                        .author("우재남")
                        .category("IT전문서")
                        .date("2022/01/22")
                        .build()
        );
        bookList.add(
                new Book
                        .Builder()
                        .bookNo("ISBN1236")
                        .price(20000)
                        .title("컴퓨팅 사고력을 키우는 블록 코딩")
                        .subject("스크래치")
                        .author("고광일")
                        .category("컴퓨터입문")
                        .date("2022/06/10")
                        .build()
        );

    }

    // bookList 에 담긴 책의 정보를 출력합니다.
    public void printBookList(List<Book> bookList) {
        String format = "%s | %s | %d | %s | %s | %s | %s | %d \n";
        try {
            if (bookList.isEmpty()) System.out.println("책 리스트가 비었습니다");
            else {
                bookList.forEach(book -> {
                    if (book != null) {
                        try {
                            System.out.printf(format,
                                    book.bookNo, book.subject, book.price,
                                    book.author, book.title, book.category,
                                    book.date, book.quantity);
                        } catch (Exception e) {
                            System.out.println("책 리스트를 출력하는데 에러가 났습니다." + e.toString());
                        }
                    }
                });
            }

        } catch (NullPointerException npe) {
            System.out.println("책의 정보를 찾을 수 없습니다.");
            System.out.println(npe.toString());
            throw npe;
        } catch (Exception e) {
            System.out.println("에러발생. 추가 예외처리 필요. 아마 format 에러?");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * TODO:: 필요없을거 같은데?
     *
     * @param index
     * @return
     */
    public Book getTheBookWithIndex(int index) {
        try {
            return bookList.get(index);
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("해당 위치(index)의 책 정보를 불러오는데 문제가 발생하였습니다.");
            throw iobe;
        }
    }

    public Book getTheBookWithISBN(String isbn) {
        try {
            return bookList.stream().filter(book -> book.getBookNo().equals(isbn))
                    .findAny()
                    .orElse(null);
        } catch (NullPointerException npe) {
            System.out.printf("이름이 %s 인 책을 찾을수 없습니다.\n", isbn);
            throw npe;
        }
    }


}
