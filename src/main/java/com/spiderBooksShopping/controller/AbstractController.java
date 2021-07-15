package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.List;

public abstract class AbstractController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestService restService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    @ModelAttribute("firstName")
    public String getFirstName(Principal principal) {
        if (principal != null) {
            return customerService.getCustomerFirstName(principal).getFirstName();
        }
        return null;
    }
    @ModelAttribute("list")
    public List<BookDto> getBookData()
    {
        List<BookDto> list= restService.getRestProduct();
        System.out.println(list.toString());
        return list;

    }

    @ModelAttribute
    public void loadConfiguration() {
        BasicConfigurator.configure();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        BasicConfigurator.configure();
        logger.info(" Inside initBinder method at AbstractController class");
        StringTrimmerEditor firstName = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class, "firstName", firstName);

        StringTrimmerEditor password = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class, "password", password);

        StringTrimmerEditor addressLine1 = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class, "addressLine1", addressLine1);

        StringTrimmerEditor bookName = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class, "bookName", bookName);

        StringTrimmerEditor author = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class, "author", author);
    }
}
