package com.spiderBooksShopping.customValidator;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import com.spiderBooksShopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomerDto.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        CustomerDto customerDto = (CustomerDto) object;
        String password = customerDto.getPassword();
        String rePassword = customerDto.getRePassword();

        addressLine1Validation(customerDto.getAddressLine1(), errors);
        cityValidation(customerDto.getCity(), errors);
        stateValidation(customerDto.getState(), errors);
        dobValidation(customerDto.getDob(), errors);
        emailValidation(customerDto.getEmail(), errors);
        contactValidation(customerDto.getContact(), errors);
        pinCodeValidation(customerDto.getPincode(), errors);
        passwordValidation(customerDto.getPassword(), errors);
        rePasswordValidation(customerDto.getRePassword(), errors);
        validateCustomerFirstName(customerDto.getFirstName(), errors);
        validateCustomerLastName(customerDto.getLastName(), errors);

        //Business validation Logic For Password and RePassword
        if (!password.equals(rePassword)) {
            errors.rejectValue("password", "CustomerDto.password.missMatch");
        }
    }

    //LastName
    private void validateCustomerLastName(String lastName, Errors errors) {
        if (lastName.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.errors", "*firstName cannot be empty");
        } else if (!lastName.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$+")) {
            errors.rejectValue("lastName", "CustomerDto.lastName.invalid");
        }

    }

    //FirstName
    private void validateCustomerFirstName(String firstName, Errors errors) {
        if (firstName.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.errors", "*firstName cannot be empty");
        } else if (!firstName.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._ ]+(?<![_.])$")) {
            errors.rejectValue("lastName", "CustomerDto.firstName.invalid");
        }
    }

    //rePassword
    private void rePasswordValidation(String rePassword, Errors errors) {
        if (rePassword.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "CustomerDto.password");
        }
    }

    //Password
    private void passwordValidation(String password, Errors errors) {
        if (password.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rePassword", "CustomerDto.rePassword");
        }
    }

    //PinCode
    private void pinCodeValidation(String pincode, Errors errors) {
        if (pincode.isEmpty()) {
            errors.rejectValue("pincode", "CustomerDto.pincode");
        } else if (!pincode.matches("^[1-9][0-9]{5}$")) {
            errors.rejectValue("pincode", "CustomerDto.pincode.invalid");
        }
    }

    //Contact
    private void contactValidation(String contact, Errors errors) {
        if (contact.isEmpty()) {
            errors.rejectValue("contact", "CustomerDto.contact");
        } else if (!contact.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
            errors.rejectValue("contact", "CustomerDto.contact.invalid");
        }
    }

    //Email
    private void emailValidation(String email, Errors errors) {
        if (email.isEmpty()) {
            errors.rejectValue("email", "CustomerDto.email");
        } else if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email", "CustomerDto.email.invalid");
        }
    }

    //Date Of Birth
    private void dobValidation(String dob, Errors errors) {
        if (dob.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "CustomerDto.dob");
        }
    }

    //State
    private void stateValidation(String state, Errors errors) {
        if (state.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "CustomerDto.state");
        } else if (!state.matches("^(?=.{2,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")) {
            errors.rejectValue("state", "CustomerDto.state");
        }
    }

    //City
    private void cityValidation(String city, Errors errors) {
        if (city.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "CustomerDto.city");
        }
    }

    //Address
    private void addressLine1Validation(String addressLine1, Errors errors) {
        if (addressLine1.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "CustomerDto.addressLine1");
        } else if (!addressLine1.matches("^[#.0-9a-zA-Z\\s,-]+$")) {
            errors.rejectValue("addressLine1", "CustomerDto.addressLine1");
        }
    }

}
