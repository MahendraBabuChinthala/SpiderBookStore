package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@SessionAttributes("bookDto")
@Controller
@RequestMapping("/")
public class BooksRestCallController extends AbstractController {

    @Autowired
    private RestService restService;

    @Autowired
    private CustomerService customerService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    //This Method BeLongs To Get ALl Books List From Server Side to clint side
    @RequestMapping(value = "/getAllBooksData", method = RequestMethod.GET)
    public String getAllBooksData(Model model) {
        model.addAttribute("bookDto", new BookDto());
        List<BookDto> bookDto = restService.getRestProduct();
        logger.info(" Inside getAllBooksData method at BookRestCallController class" + bookDto);
        model.addAttribute("bookDto", bookDto);
        return "getAllBooksData";
    }

    //Get The Single Book By Using BookId In This Method
    @RequestMapping(value = "/getBookByBookId/{bookId}", method = RequestMethod.GET)
    public String getBookByBookId(@PathVariable("bookId") String bookId, Model model) {
        BookDto bookDto = restService.getBookByBookId(bookId);
        logger.info(" Inside getBookByBookId method at BookRestCallController class" + bookDto);
        //firstName Abstract Code
        if (bookDto != null) {
            model.addAttribute("bookDto", bookDto);
            return "getSingleBook";
        }
        return "bookIdError";
    }

    //client side Add Book Form
    @RequestMapping(value = "/sellerAddBook", method = RequestMethod.GET)
    public String sellerAddBook(Principal principal, Model model) {
        //firstName Abstract Code
        model.addAttribute("bookDto", new BookDto());
        logger.info(" Inside sellerAddBook method at BookRestCallController class");
        return "addBookFormPage";
    }

    //This Method BeLongs To Client Side Save Book
    @RequestMapping(value = "/clientSideBookAddToServerSide", method = RequestMethod.POST)
    public String clientSideBookAddToServerSide(Principal principal, @Valid @ModelAttribute("bookDto") BookDto bookDto, BindingResult bindingResult, Model model) {
        //firstName Abstract Code
        bookDto.setSellerName(principal.getName());
        int count = customerService.bookIdCount(bookDto);
        if (count > 0) {
            bindingResult.rejectValue("bookId", "BookDto.bookId.error", " * BookId Already In Use");
            logger.info(" Email should be Duplicated");
        }
        if (bindingResult.hasErrors()) {
            logger.error("error inside  clientSideBookAddToServerSide method at BookRestCallController class" + bindingResult);
            return "addBookFormPage";
        } else {
            int bookDto1 = restService.clientSideBookAddToServerSide(bookDto);
            logger.info(" Inside clientSideBookAddToServerSide method at BookRestCallController class" + bookDto);
            model.addAttribute("bookDto1", bookDto1);
            return "clintBookSuccessFullyAdd";
        }
    }

    //This Method Belongs To Book Edit Form Page
    @RequestMapping(value = "/editBook/{bookId}", method = RequestMethod.GET)
    public String getEdit(Principal principal, @PathVariable String bookId, Model model) {
        BookDto bookDto = restService.getBookByBookId(bookId);
        logger.info(" Inside editBook method at BookRestCallController class" + bookDto);
        //firstName Abstract Code
        if (bookDto != null) {
            model.addAttribute("bookDto", bookDto);
            return "editBookAndSave";
        }
        return "bookIdError";
    }

    //This Method BeLongs To Edit and Save the Book In Clint Side To Server Side
    @RequestMapping(value = "/clientSideBookUpdateToServerSide", method = RequestMethod.POST)
    public String clientSideBookUpdateToServerSide(Principal principal, @Valid @ModelAttribute("bookDto") BookDto bookDto, BindingResult bindingResult) {
        String sellerName = principal.getName();
        bookDto.setSellerName(sellerName);
        if (bindingResult.hasErrors()) {
            logger.error("error Inside clientSideBookUpdateToServerSide method at BookRestCallController class" + bindingResult);
            return "editBookAndSave";
        } else {
            restService.clientSideBookUpdateToServerSide(bookDto);
            logger.info(" Inside ClientSideBookUpdate To ServerSide method at BookRestCallController class" + bookDto);
            return "updateBookSuccessFully";
        }
    }

    //Delete The Book Details From Client Side To Server Side
    @RequestMapping(value = "/deleteBookById/{bookId}", method = RequestMethod.GET)
    public String deleteBookById(@PathVariable("bookId") String bookId) {
        restService.deleteBookByBookId(bookId);
        logger.info("inside deleteBookById method at BookRestCallController class");
        return "redirect:/getSellerNameBooksData";
    }
}

