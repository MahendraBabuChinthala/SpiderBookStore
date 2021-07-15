package com.spiderBooksShopping.controller;

import com.spiderBooksShopping.customValidator.CustomerValidator;
import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.restServices.RestService;
import com.spiderBooksShopping.service.CustomerService;
import org.apache.jasper.JasperException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController extends AbstractController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private RestService restService;

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    //Customer Registration Form Page
    @RequestMapping(value = "/customerRegistration", method = RequestMethod.GET)
    public String customerRegistration(Model model) {
        logger.info(" Inside  customerRegistration method at CustomerController class");
        model.addAttribute("customerDto", new CustomerDto());
        return "customerRegistrationForm";
    }

    //Save Customer Details Inside DataBase
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customerDto") CustomerDto customerDto, BindingResult result) {
        int count = customerService.emailCount(customerDto);
        if (count > 0) {
            result.rejectValue("email", "CustomerDto.email.error", " * Email address is already in use");
            logger.info(" Email should be Duplicated");
        }
        customerValidator.validate(customerDto, result);
        if (result.hasErrors()) {
            logger.error("error inside  customerSaveData method at CustomerController class" + result);
            return "customerRegistrationForm";
        } else {
            customerService.saveCustomer(customerDto);
            logger.info(" Inside customerSaveData method at CustomerController class");
            return "login";
        }
    }

    //Retrieving  AllBookData From DataBase
    @RequestMapping(value = "/allCustomersData", method = RequestMethod.GET)
    public String getAllCustomersData(Model model) {
        try {
            List<CustomerDto> allCustomersData = customerService.allCustomersData();
            logger.info(" inside getAllCustomerData method at CustomerController class" + allCustomersData);
            model.addAttribute("allCustomersData", allCustomersData);
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("error", "No record found");
            logger.error("error Inside allCustomersData method at CustomerController class");
            e.getStackTrace();
        }
        return "customersListPage";
    }

    //Get The Single Customer By Using Email
    @RequestMapping(value = "/getSingleCustomer")
    public String oneCustomer(Principal principal, Model model) {
        try {
            CustomerDto customerDto = customerService.getCustomerEmail(principal.getName());
            logger.info(" Inside getSingleCustomer method at CustomerController class" + customerDto);
            model.addAttribute("customerDto", customerDto);
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("error", "No record found by emailId you entered");
            e.getStackTrace();
        }
        return "customerDetailsPage";
    }

    //Update Customer Form Page
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
    public String edit(Principal principal, Model model) {
        CustomerDto customerDto = customerService.getCustomerEmail(principal.getName());
        logger.info(" Inside updateCustomer through email method at CustomerController class" + customerDto);
        model.addAttribute("customerDto", customerDto);
        return "updateCustomerForm";
    }

    //Update And Save The Customer Details In DataBase
    @RequestMapping(value = "/updateCustomerSave", method = RequestMethod.POST)
    public String productSave(Principal principal, @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult result) {
        customerDto.setEmail(principal.getName());
        customerValidator.validate(customerDto, result);
        if (result.hasErrors()) {
            logger.error("error inside  updateCustomerSave method at CustomerController class" + result);
            return "updateCustomerForm";
        } else {
            customerService.updateCustomer(customerDto);
            logger.info(" inside updateCustomerSave method at CustomerController class");
        }
        return "editCustomerSuccessFully";
    }

    //Deleting The CustomerData by using Email
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public String delete(@RequestParam("email") String email) {
        customerService.deleteCustomer(email);
        logger.info(" inside DeleteCustomer method at CustomerController class");
        return "redirect:/login";
    }
}
