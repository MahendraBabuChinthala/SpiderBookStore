package com.spiderBooksShopping.service;

import com.spiderBooksShopping.dao.CustomerDao;
import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import org.springframework.dao.EmptyResultDataAccessException;

import java.security.Principal;
import java.util.List;
import java.util.Random;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public int saveCustomer(CustomerDto customerDto) {
        return customerDao.saveCustomer(customerDto);
    }

    @Override
    public int updateCustomer(CustomerDto customerDto) throws NullPointerException {
        return customerDao.updateCustomer(customerDto);
    }

    @Override
    public CustomerDto getCustomerEmail(String email) throws EmptyResultDataAccessException {
        CustomerDto searchEmail = customerDao.getCustomerEmail(email);
        return searchEmail;
    }

    @Override
    public int deleteCustomer(String email) {
        return customerDao.deleteCustomer(email);
    }

    @Override
    public List<CustomerDto> allCustomersData() throws EmptyResultDataAccessException {
        return customerDao.allCustomersData();
    }

    //Get Customer FirstName
    @Override
    public CustomerDto getCustomerFirstName(Principal principal){
        return customerDao.getCustomerFirstName(principal);
    }

    @Override
    public int emailCount(CustomerDto customerDto) {
        return customerDao.emailCount(customerDto);
    }

    @Override
    public int bookIdCount(BookDto bookDto) {
        return customerDao.bookIdCount(bookDto);
    }

    //Place Order And call method OrderId Random Increment Logic
    @Override
    public int placeOrderSave(CustomerDto customerDto) {
        Random random = new Random();
        customerDto.setOrderId(random.nextLong());
        return customerDao.placeOrderSave(customerDto);
    }

    @Override
    public CustomerDto getPlaceOrder(long orderId) {
        return null;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
