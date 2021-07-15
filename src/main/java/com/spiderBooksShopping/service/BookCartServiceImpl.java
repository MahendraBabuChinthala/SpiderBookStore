package com.spiderBooksShopping.service;

import com.spiderBooksShopping.dao.BookCartDao;
import com.spiderBooksShopping.dto.BookCartDto;
import com.spiderBooksShopping.dto.BookDto;

import java.util.List;

public class BookCartServiceImpl implements BookCartService {

    private BookCartDao bookCartDao;

    @Override
    public int saveBookCart(BookCartDto bookCartDto) {
        return bookCartDao.saveBookCart(bookCartDto);
    }

    @Override
    public BookCartDto getCartBook(int cartId) {
        return bookCartDao.getCartBook(cartId);
    }

    @Override
    public int updateBookCart(BookCartDto bookCartDto) {
        return bookCartDao.updateBookCart(bookCartDto);
    }

    @Override
    public int deleteBookCart(int cartId) {
        return bookCartDao.deleteBookCart(cartId);
    }

    @Override
    public List<BookCartDto> allBookCartData(String userId) {
        return bookCartDao.allBookCartData(userId);
    }

    public BookCartDao getBookCartDao() {
        return bookCartDao;
    }

    public void setBookCartDao(BookCartDao bookCartDao) {
        this.bookCartDao = bookCartDao;
    }
}
