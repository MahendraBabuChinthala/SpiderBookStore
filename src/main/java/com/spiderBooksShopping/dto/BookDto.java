package com.spiderBooksShopping.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class BookDto {

    @Pattern(regexp = "^(?=.{1,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._-]+(?<![_.])$", message = " * Give BookId Should Be Unique ")
    private String bookId;

    @Pattern(regexp = "^(?=.{3,50}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$", message = " * Give Valid Book Name")
    private String bookName;

    @Pattern(regexp = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$", message = " * Give Valid Book author")
    private String author;

    @Pattern(regexp = "^(?=.{3,100}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$", message = " * Give Valid Book description")
    private String description;

    @NotEmpty(message = " * Price Should Not Be Empty")
    @Pattern(regexp = "^\\d{0,8}(\\.\\d{1,4})?$", message = " * Price Should be in Number")
    private String bookPrice;

    @NotEmpty(message = " * PublishYear Should Not Be Empty")
    private String publishYear;

    @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = " * Give Valid Book sellerName")
    private String sellerName;

    @Pattern(regexp = "^(?=.{3,100}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$", message = " * Publication Should Not Be Empty")
    private String publication;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", publication='" + publication + '\'' +
                '}';
    }

  /*  private List<BookDto> bookDtos;

    public List<BookDto> findAll() {
        return this.bookDtos;
    }

    public BookDto find(String bookId) {
        for (BookDto bookDto : this.bookDtos) {
            if (bookDto.getBookId().equalsIgnoreCase(bookId)) {
                return bookDto;
            }
        }
        return null;
    }*/
}
