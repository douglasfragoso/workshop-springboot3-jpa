package com.java.spring.course.enums;

public enum OrderStatus {
    
    WAITING_PAYMENT(1),// This attribute is used to store the code of the order status - TIPO(VALOR)
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code; // This attribute is used to store the code of the order status

    private OrderStatus(int code) { // Constructor
        this.code = code;
    }	

    public int getCode() { // Getter
        return code;
    }

    public static OrderStatus valueOf(int code) { // This method is used to convert an integer to an OrderStatus
        for (OrderStatus value : OrderStatus.values()) { // For each OrderStatus value in OrderStatus.values()
            if (value.getCode() == code) { // If the value.getCode() is equal to the code
                return value; // Return the value
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code"); // If the code is invalid, throw an exception
    }
}
