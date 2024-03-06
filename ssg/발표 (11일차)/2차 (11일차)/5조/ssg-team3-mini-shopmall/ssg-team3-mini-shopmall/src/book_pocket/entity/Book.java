package book_pocket.entity;

public class Book {
    private String isbn;
    private String name;
    private int price;
    private String author;
    private String desc;
    private String category;
    private String datePublish;

    public Book(String isbn, String name, int price, String author, String desc, String category, String datePublish) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.author = author;
        this.desc = desc;
        this.category = category;
        this.datePublish = datePublish;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return isbn + " | " + name + " | " + price + " | " + author + " | " + desc + " | " + category + " | " + datePublish + " |";
    }
}