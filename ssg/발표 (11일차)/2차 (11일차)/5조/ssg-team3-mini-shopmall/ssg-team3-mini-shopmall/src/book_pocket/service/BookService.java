package book_pocket.service;

import book_pocket.entity.Book;

public class BookService {
    private Book[] books = {
            new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08"),
            new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22"),
            new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10"),
    };

    public int getLengthBooks() {
        return books.length;
    }

    public Book getBookById(int idx) {
        return books[idx];
    }
}
