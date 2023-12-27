package oop.day5;

/**
 * 열거타입 : 상태정보를 표현 할 수 있음
 */
public enum OrderState {
      PAYMENT_WAITING
    , PREPARING
    , SHIPPED
    , DELIVERING
    , DELIVERY_COMPLETED
    , CANCELLED;
}
