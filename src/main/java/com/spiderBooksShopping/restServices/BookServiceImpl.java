package com.spiderBooksShopping.restServices;

import com.spiderBooksShopping.dto.BookDto;

import java.util.List;

public class BookServiceImpl implements RestService {

    @Override
    public List<BookDto> getRestProduct() {
        return null;
    }

    @Override
    public BookDto getBookByBookId(String bookId) {
        return null;
    }

    @Override
    public int deleteBookByBookId(String bookId) {
        return 0;
    }

    @Override
    public int clientSideBookAddToServerSide(BookDto bookDto) {
        return 0;
    }

    @Override
    public int clientSideBookUpdateToServerSide(BookDto bookDto) {
        return 0;
    }

    @Override
    public List<BookDto> getSellerNameBooksData(String email) {
        return null;
    }
}
