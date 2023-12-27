package oop.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 주문은 '출고상태 변경하기', '배송지 정보 변경하기', '주문취소하기', '결제완료하기'
 */
public class Order {
    private List<OrderLine> orderLines;

    // String name,  String contact, String address1, String address2, String zipcode
    private ShippingInfo shippingInfo;

    private Money totalAmounts;

    private OrderState state;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null)
            throw new IllegalArgumentException("no ShippingInfo");
        this.shippingInfo = shippingInfo;
    }


    // 최소값 검사하고 총 주문량 계산해서 출력
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLine(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        int sum = orderLines.stream().mapToInt(x -> x.getAmount()).sum();
        this.totalAmounts = new Money(sum);
    }

    private void verifyAtLeastOneOrMoreOrderLine(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    public void changeDelivered(ShippingInfo shippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(shippingInfo);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalArgumentException("Already shipped");
    }

    public void changeDeliveryInfo (ShippingInfo shippingInfo) {

    }


    public void cancelOrder() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELLED;
    }


    public void completePayment() {

    }
}
