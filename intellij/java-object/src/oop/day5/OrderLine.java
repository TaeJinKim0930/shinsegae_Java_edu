package oop.day5;


/**
 * 주문항목 표현 클래스 : 주문할 상품, 상품의 가격, 구매 개수, 각 구매 항목의 구매 가격 제공
 * 한 상품(product)을 얼마에 (price) 몇개(quantity) 살지 담고, calculateAmount() 에서 계산을 하는 로직 입니다.
 *
 */
public class OrderLine {
    // product = String productID, int price
    private Product product;
    private int price;
    private int quantity;
    private int amount;

    public int getAmount() {
        return amount;
    }


    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    private int calculateAmounts() {
        return this.price * quantity;
    }
}
