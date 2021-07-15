package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.service.CustomerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CheckOutController {
    @Autowired
    private CustomerService customerService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    //This method belongs to checkOutPage
    @RequestMapping(value = "/checkOutPage")
    public String checkOutPage(Principal principal, Model model, BookDto bookDto) {
        CustomerDto customerDto = customerService.getCustomerEmail(principal.getName());
        logger.info(" inside checkOutPage method at CustomerController class" + customerDto);
        model.addAttribute("bookDto", bookDto);
        model.addAttribute("customerDto", customerDto);
        return "checkOutForm";
    }

    //Save Order details inside database
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(@SessionAttribute(required = false) BookDto bookDto, Principal principal, @Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.error("error inside  saveOrder method at CustomerController class");
            return "checkOutForm";
        } else {
            customerDto.setProductId(bookDto.getBookId());
            customerDto.setEmail(principal.getName());
            long customerDto1 = customerService.placeOrderSave(customerDto);
            logger.info(" inside saveOrder method at CustomerController class" + customerDto1);
            model.addAttribute(customerDto1);
            model.addAttribute("bookDto", bookDto);
        }
        return "orderSuccessFullyPlacedPage";
    }
}
