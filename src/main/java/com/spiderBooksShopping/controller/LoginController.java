package com.spiderBooksShopping.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class LoginController extends AbstractController {

    private static Logger logger = LogManager.getLogger(HomeController.class);

    //Spring Security Login And Logout Method
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        BasicConfigurator.configure();
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
            logger.error("error in side LoginController" + error);
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
            logger.error("Inside Login and Logout method at LoginControlller");
        }
        model.setViewName("login");

        return model;

    }

    // For 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }
        model.setViewName("403");
        return model;
    }
}
