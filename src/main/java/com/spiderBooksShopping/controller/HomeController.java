package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({"bookDto", "getFirstName"})
@RequestMapping("/")
public class HomeController extends AbstractController {

    @Autowired
    private RestService restService;

    @Autowired
    private CustomerService customerService;

    private static Logger logger = LogManager.getLogger(HomeController.class);

    //home
    @RequestMapping(value = {"/", "/customerHome"})
    public String customerHome(Principal principal, Model model, CustomerDto customerDto) {
        model.addAttribute("bookDto", new BookDto());
        List<BookDto> bookDto = restService.getRestProduct();
        logger.info(" Inside the Spider Book Store CustomerHome method at  CustomerHomeController ");
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("bookDto", bookDto);
        return "customerHomePage";
    }

    //AboutUs
    @RequestMapping(value = "/spiderBookStoreAboutUs", method = RequestMethod.GET)
    public String aboutUs(Principal principal, Model model) {
        logger.info(" Inside  SpiderBookStoreAboutUs method at CustomerHomeController ");
        return "aboutUsPage";
    }
}
