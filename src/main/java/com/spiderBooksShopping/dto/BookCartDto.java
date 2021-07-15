package com.spiderBooksShopping.dto;

public class BookCartDto {
    private int cartId;
    private String userId;
    private String bookId;
    private double price;
    private int quantity;
    private double subTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "BookCartDto{" +
                "cartId=" + cartId +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }

    /* public BookCartDto(BookDto bookDto, int quantity) {
        this.bookDto = bookDto;
        this.quantity = quantity;
    }*/

}
