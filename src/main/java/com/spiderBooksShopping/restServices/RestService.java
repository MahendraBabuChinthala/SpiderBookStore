package com.spiderBooksShopping.restServices;

import com.spiderBooksShopping.dto.BookDto;
import org.springframework.web.client.RestClientException;

import java.util.List;

public interface RestService {
    /**
     * Get The List Of Books Data from Server Side Through RestService
     *
     * @return
     */
    public List<BookDto> getRestProduct();

    /**
     * Get SingleBook Data From Server Through RestService
     *
     * @param bookId
     * @return
     */
    public BookDto getBookByBookId(String bookId);

    /**
     * Delete The Book From Server Side Through RestService
     *
     * @param bookId
     * @return
     */
    public int deleteBookByBookId(String bookId);

    /**
     * client Side Book Add To Server Side Through RestService
     *
     * @param bookDto
     * @return
     */
    public int clientSideBookAddToServerSide(BookDto bookDto);

    /**
     * client Side Book Update To Server Side Through RestService
     *
     * @param bookDto
     * @return
     */
    public int clientSideBookUpdateToServerSide(BookDto bookDto);

    /**
     * Get SellerName BooksData Through RestService
     *
     * @param email
     * @return
     */
    public List<BookDto> getSellerNameBooksData(String email);
}
