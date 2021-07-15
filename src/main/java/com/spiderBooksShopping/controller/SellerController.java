package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.restServices.RestService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class SellerController extends AbstractController {
    @Autowired
    private RestService restService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    //sellerPortal
    @RequestMapping(value = "/sellerPortal")
    public String sellerPortal(Model model) {
        logger.info(" inside sellerPortal method at CustomerController class");
        model.addAttribute("bookDto", new BookDto());
        List<BookDto> bookDto = restService.getRestProduct();
        model.addAttribute("bookDto", bookDto);
        return "sellerPortalPage";
    }

    //Get SellerName Books List From Server Side To Client Side
    @RequestMapping(value = "/getSellerNameBooksData", method = RequestMethod.GET)
    public String getSellerNameBooksData(Model model, Principal principal) {
        //firstName Abstract Code
        model.addAttribute("bookDto", new BookDto());
        List<BookDto> sellerNameBooksData = restService.getSellerNameBooksData(principal.getName());
        logger.info(" Inside getSellerNameBooksData method at BookRestCallController class" + sellerNameBooksData);
        model.addAttribute("sellerNameBooksData", sellerNameBooksData);
        return "sellerNameBooks";
    }

}
