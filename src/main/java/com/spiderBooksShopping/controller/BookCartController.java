package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookCartDto;
import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.BookCartService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class BookCartController extends AbstractController {

    @Autowired
    private BookCartService bookCartService;

    @Autowired
    private RestService restService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    //Save book details inside database
    @RequestMapping(value = "/addToCart")
    public String addToCart(@RequestParam("bookId") String bookId, Principal principal) {
        BookDto bookDto = restService.getBookByBookId(bookId);
        BookCartDto bookCartDto = new BookCartDto();
        bookCartDto.setUserId(principal.getName());
        bookCartDto.setBookId(bookDto.getBookId());
        double price = Double.parseDouble(bookDto.getBookPrice());
        bookCartDto.setPrice(price);
        bookCartDto.setQuantity(1);
        bookCartDto.setSubTotal(price * bookCartDto.getQuantity());
        bookCartService.saveBookCart(bookCartDto);
        return "redirect:/allBookCartData";
    }

    //Retrieving  AllBookData in DB
    @RequestMapping(value = "/allBookCartData", method = RequestMethod.GET)
    public String getAllDataOfBook(Model model, Principal principal) {
        try {
            List<BookCartDto> allBooksData = bookCartService.allBookCartData(principal.getName());
            logger.info(" Inside allBookCartData method at BookCartController class" + allBooksData);
            model.addAttribute("allBooksData", allBooksData);
        } catch (EmptyResultDataAccessException e) {
            logger.error("error Inside allBookCartData method at BookCartController class" + e);
        }
        return "bookCartPLP";
    }

    //Deleting the BookData by using BookID
    @RequestMapping(value = "/deleteBookCart", method = RequestMethod.GET)
    public String delete(@RequestParam("cartId") int cartId) {
        bookCartService.deleteBookCart(cartId);
        logger.info(" Inside deleteBookCart method at BookCartController class" + cartId);
        return "redirect:/allBookCartData";
    }

    //edit Book by BookId
    @RequestMapping(value = "/updateBook", method = RequestMethod.GET)
    public String edit(@RequestParam("cartId") int cartId, Model model) {
        BookCartDto bookCartDto = bookCartService.getCartBook(cartId);
        //BookDto bookDto = restService.getBookByBookId(bookId);
        logger.info(" Inside Edit method at BooksController class" + bookCartDto);
        model.addAttribute("bookCartDto", bookCartDto);
        return "redirect:/bookCartPLP";
    }


    //edit Book by BookId
   /* @RequestMapping(value = "/updateBookCart", method = RequestMethod.POST)
    public String edit(Model model, BookCartDto bookCartDto) {
        bookCartService.updateBookCart(bookCartDto);
        logger.info(" Inside Edit method at BooksController class" + bookCartDto);
        model.addAttribute("bookCartDto", bookCartDto);
        return "redirect:/allBookCartData";
    }*/


/* @RequestMapping(value = "shop/index")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView("shop/list");
        List<Book> bookList=bookDao.getall();
        mav.addObject("listResult",bookList);
        return mav;
    }*//*


     */
/*   @RequestMapping(value = "shop/index")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView("shop/list");
        List<BookDto> bookList=restService.getRestProduct();
        mav.addObject("listResult",bookList);
        return mav;
    }*//*

}
*/
}
