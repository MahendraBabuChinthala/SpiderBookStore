/*
package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookCartDto;
import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.BookCartService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Shoppingcart")
public class ShoppingController extends AbstractController {
    @Autowired
    private BookCartService bookCartService;

    @Autowired
    private RestService restService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam("bookId") String bookId, Principal principal,Model model,BookDto bookDto) {
        BookDto bookCartDto = restService.getBookByBookId(bookId);
        try{
            bookCartDto.setSellerName(principal.getName());
            bookCartService.saveBookCart(bookCartDto);
            model.addAttribute("book1",bookCartDto);
            return "redirect:/getAllCartBook";
        } catch (NullPointerException e) {
            e.printStackTrace();
            model.addAttribute("bookInfo","DATA NOT FOUND");
        }
        return "error";
    }
    @RequestMapping(value = "/getAllCartBook",method = RequestMethod.GET)
    public String getALLCartBook(Principal principal, Model model)
    {
        try {
            List<Book> lstBook=addToCardService.getListBookFromTheCart(principal.getName());
            model.addAttribute("lstOfBook",lstBook);
            return "cart";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "error";


    }

    @RequestMapping(value = "delete/{bookId}",method = RequestMethod.GET)
    public String deleteCartBook(@PathVariable("bookId") String bookId,Model model)
    {
        model.addAttribute("bookId",bookId);
        addToCardService.deleteCartBook(bookId);
        return "redirect:/getAllCartBook";
    }
    @RequestMapping(value = "/orderPlaced/{total}",method = RequestMethod.GET)
    public String orderPlaced(@ModelAttribute("order") Order order,@PathVariable("total") Integer total,Principal principal,Model model)
    {
        if(total!=0) {
            Order order1 = addToCardService.saveOrder(order, principal);
            model.addAttribute("order", order1);
            model.addAttribute("total", total);
            addToCardService.deleteAllCardBook(principal.getName());
            return "orderPlacedPageCart";
        }else {
            model.addAttribute("cardError","There Is No Book Added To Cart please add single item and place order");
            return "error";
        }
    }

}
*/
