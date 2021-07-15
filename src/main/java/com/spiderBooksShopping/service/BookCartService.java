package com.spiderBooksShopping.service;

import com.spiderBooksShopping.dto.BookCartDto;
import com.spiderBooksShopping.dto.BookDto;

import java.util.List;

public interface BookCartService {
    public int saveBookCart(BookCartDto bookCartDto);
    public BookCartDto getCartBook(int cartId);
    public int updateBookCart(BookCartDto bookCartDto);
    public int deleteBookCart(int cartId);
    public List<BookCartDto> allBookCartData(String userId);
}
