package com.spiderBooksShopping.dao;

import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;

import java.security.Principal;
import java.util.List;

public interface CustomerDao {
    /**
     * Save The Customer Details In DataBase
     *
     * @param customerDto
     * @return
     */
    public int saveCustomer(CustomerDto customerDto);

    /**
     * Update The Customer Details In DataBase
     *
     * @param customerDto
     * @return
     */
    public int updateCustomer(CustomerDto customerDto);

    /**
     * Get Single Customer Details In DataBase By Email
     *
     * @param email
     * @return
     */
    public CustomerDto getCustomerEmail(String email);

    /**
     * Delete Customer Details From DataBase By Email
     *
     * @param email
     * @return
     */
    public int deleteCustomer(String email);

    /**
     * GEt List Of All CustomerData From DataBase
     *
     * @return
     */
    public List<CustomerDto> allCustomersData();

    /**
     * Save The Order Details In DataBase
     *
     * @param customerDto
     * @return
     */
    public int placeOrderSave(CustomerDto customerDto);

    /**
     * get the Order Details From DateBase
     *
     * @param orderId
     * @return
     */
    public CustomerDto getPlaceOrder(long orderId);

    /**
     * Get Customer FirstName From DataBase
     *
     * @param principal
     * @return
     */
    public CustomerDto getCustomerFirstName(Principal principal);

    /**
     * This Method Check Duplicate Email
     *
     * @param customerDto
     * @return
     */
    public int emailCount(CustomerDto customerDto);

    /**
     * This Method Check Duplicate BookId
     *
     * @param bookDto
     * @return
     */
    public int bookIdCount(BookDto bookDto);
}
