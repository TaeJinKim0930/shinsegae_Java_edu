package project.project1.shoppingList.entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 8개의 필드와 1개의 Builder 클래스 1개의 생성자 6개의 메소드를 가지고 있는 Book 클래스 입니다.
 */
public class Book {
    // Book 의 값을 재설정 해주고 지워주는 과정이 필요해서 필수 값이 없습니다.
    public final String bookNo;
    public final String subject;
    public final int price;
    public final String author;
    public final String title;
    public final String category;
    public final String date;
    public int quantity;

    public static class Builder {

        private String bookNo;
        private String subject;
        private int price;
        private String author;
        private String title;
        private String category;
        private String date;
        private int quantity;


        public Builder bookNo(String val) {
            bookNo = val;
            return this;
        }

        public Builder price(int val) {
            price = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder subject(String val) {
            subject = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder category(String val) {
            category = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(Builder builder) {
        this.bookNo = builder.bookNo;
        this.subject = builder.subject;
        this.price = builder.price;
        this.author = builder.author;
        this.title = builder.title;
        this.category = builder.category;
        this.date = builder.date;
        this.quantity = builder.quantity;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void printArrList(Book[] bookArr) {
        printFormattedBooks(bookArr, "%s | %s | %d | %s | %s | %s | %s | %d \n");
    }

    /**
     * 영수증에 필요한 데이터들을 null 값과 N/A 값을 필터링을 걸쳐서 Book 배열에서 출력합니다.
     * @see ShoppingMallMain 에서 case 7에서 영수증을 출력할 때 사용됩니다.
     * @param bookArr
     */
    public void printArrReceipt(Book[] bookArr) {
        try {
            // TODO::format 쓰려다가 실패
//            printFormattedBooks(bookArr, "%s | %d | %s | %d \n", );

            // book 배열에서 null 값과 N/A 값이 아닌 Book 의 값들을 for each loop 돌면서 출력해줍니다.
            Arrays.stream(bookArr)
                    .filter(book -> book != null && !"N/A".equals(book.bookNo))
                    .forEach(book -> {
                        System.out.printf("%s | %d | %s | %d \n",
                                book.bookNo, book.price,
                                book.title, book.quantity
                        );
                    });

            // stream 을 이용한 sum 입니다. 만약 book 의 값이 null 이 아니라면 가격과 수량을 곲해주고 null 값이라면 0 으로 return 한 값을 더해줍니다.
            int sum = Arrays.stream(bookArr)
                    .mapToInt(book -> book != null ? (book.price * book.quantity) : 0)
                    .sum();
            System.out.println("Total : " + sum);
        } catch (NullPointerException e) {
            System.out.println(e);
        }

    }

    /**
     * 배열과 영수증 출력을 위해서 null 값과 "N/A" 값을 필터링 해주고 받아오는 포멧에 맞춰서 원하는 값을 배출합니다.
     * @see printArrList : 배열에 있는 Book 리스트나 영수증 출력할때 쓰입니다.
     * @param bookArr
     * @param format
     */
    private void printFormattedBooks(Book[] bookArr, String format) {
        try {
            Arrays.stream(bookArr)
                    .filter(book -> book != null && !"N/A".equals(book.bookNo))
                    .forEach(book -> {
                        System.out.printf(format,
                                book.bookNo, book.subject, book.price,
                                book.author, book.title, book.category,
                                book.date, book.quantity
                        );
                    });
        } catch (NullPointerException e) {
            System.out.println(e);

        }

    }

    /**
     * 배열에 특정한 index 위치에 있는 Book Object 을 Book 배열에서 지워주는 Method 입니다.
     * @see ShoppingMallMain case 6 에서 특정한 장바구니 항목을 지울때 사용됩니다.
     * @param bookArr
     * @param isbnToDelete
     */
    public void deleteTheBook(ArrayList<Book> bookArr, String isbnToDelete) {
        try {
            /**
             * v0.0.1
             * 해당 인덱스 위치에 있는 book 의 값이 null 이 아니고, 주어진 ISBN 값과 일치하는 book 의 값을 book 배열에서 찾았을 경우
             * 해당 book 값을 emptyBook Method 에 설정 되어 있는 포멧으로 리셋 시켜주고 지워졌다는 표식을 isDeleted 로 남겨줍니다.
             */
//            IntStream.range(0, bookArr.length)
//                    .filter(i -> bookArr[i] != null && bookArr[i].bookNo.equals(isbnToDelete))
//                    .forEach(i -> {
//                        // Update the book if it matches the condition
//                        emptyBook(bookArr, i);
//                        isDeleted[0] = true;
//                    });
            // 만약 표식이 안남겨져있으면(안지워졌으면) 에러문구를 프린트 합니다.
            // --> (null 값이거나 잘못된 ID 값을 받아와서 배열에서 찾지 못하는 경우)
            /**
             * v0.0.2
             * .remove() Removes the first occurrence of the specified element from this list, if it is present.
             * If the list does not contain the element, it is unchanged.
             * More formally, removes the element with the lowest index i such that Objects.equals(o, get(i))
             * (if such an element exists). Returns true if this list contained the specified element
             * (or equivalently, if this list changed as a result of the call).
             * @Params:
             * o – element to be removed from this list, if present
             * @Returns:
             * true if this list contained the specified element
             */
            bookArr.get(1);
            bookArr.remove(isbnToDelete);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * Book 배열을 받아와서 비어있으면 false 로 return 을 하고 비어있지 않으면 true 로 리턴을 합니다.
     * @see switch 문에서 case 5에서 쓰입니다.
     * @param bookArr : Book 클래스의 배열
     * @return isNotEmpty : 배열이 비어있으면 false, 비어있지 않으면 true
     */
//    public boolean isNotEmpty(ArrayList<Book> bookArr) {
//        boolean isNotEmpty = false;
//
//        try {
//            /**
//               * v0.0.1
//             * bookArr에 null이 아니고 "N/A"가 아닌 bookNo를 가진 요소로 채워져 있는지 확인합니다.
//             * null 이나 N/A 값들로 채워진 값이 발견되지 않으면 표현식은 true(값이 있음)를 반환하고,
//             * 그렇지 않으면 false(값이 없음)를 반환합니다.
//             */
////            isNotEmpty = !Arrays.stream(bookArr).allMatch(book -> book == null || "N/A".equals(book.bookNo));
//        } catch (NullPointerException e) {
//            System.out.println(e);
//        }
//        return isNotEmpty;
//    }

    /**
     * v0.0.1
     * 6번 case 에서 어떠한 특정 항목을 제거할때 쓰이는 deleteTheBook 에서 쓰이는 method 로서 N/A 값과 -1 값을 가진 Book 을 생성해줍니다.
     * @see deleteTheBook(Book[] bookArr, String isbnToDelete) 에서 쓰입니다.
     * @param bookArr : book 클래스의 배열
     * @param i : 원하는 index 의 book 을 선택 할 수 있게 해줍니다.
     */
//    public void emptyBook(ArrayList<Book> bookArr) {
//
//        bookArr[i] = new Book.Builder()
//                .bookNo("N/A")
//                .price(-1)
//                .title("N/A")
//                .subject("N/A")
//                .author("N/A")
//                .category("N/A")
//                .date("N/A")
//                .quantity(-1)
//                .build();
//    }


}