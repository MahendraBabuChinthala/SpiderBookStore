package com.spiderBooksShopping.dao;

import com.spiderBooksShopping.controller.CustomerController;
import com.spiderBooksShopping.dto.BookDto;
import com.spiderBooksShopping.dto.CustomerDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LogManager.getLogger(CustomerDaoImpl.class);

    @Override
    public int saveCustomer(CustomerDto customerDto) {
        String sql = "INSERT INTO customer(firstName,lastName,email,password,rePassword,contact,dob,addressLine1,addressLine2,city,state,pincode,role) " +
                "VALUES ('" + customerDto.getFirstName() + "','" + customerDto.getLastName() + "','" + customerDto.getEmail() + "','" + customerDto.getPassword() + "','" + customerDto.getRePassword() + "','" + customerDto.getContact() + "','" + customerDto.getDob() + "','" + customerDto.getAddressLine1() + "','" + customerDto.getAddressLine2() + "','" + customerDto.getCity() + "','" + customerDto.getState() + "','" + customerDto.getPincode() + "','" + customerDto.getRole() + "')";
        try {
            return jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("error Inside saveCustomer  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public int updateCustomer(CustomerDto customerDto) {
        String sql = "UPDATE customer SET firstName='" + customerDto.getFirstName() + "', lastName='" + customerDto.getLastName()
                + "', password='" + customerDto.getPassword() + "',rePassword='" + customerDto.getRePassword() + "',contact='"
                + customerDto.getContact() + "',dob='" + customerDto.getDob() + "',addressLine1='" + customerDto.getAddressLine1() + "' , addressLine2='" + customerDto.getAddressLine2() + "' , city='" + customerDto.getCity() + "' , state='" + customerDto.getState() + "' , pincode='" + customerDto.getPincode() + "' , role='" + customerDto.getRole() + "'   where email='"
                + customerDto.getEmail() + "'";
        try {
            return jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("error Inside updateCustomer  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public CustomerDto getCustomerEmail(String email) {
        String sql = "select * from customer where email=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper<CustomerDto>(CustomerDto.class));
        } catch (DataAccessException e) {
            logger.error("error Inside getCustomerEmail  method at CustomerDaoImpl class" + e);
        }
        return null;
    }

    @Override
    public int deleteCustomer(String email) {
        String sql = "delete from customer where email=?";
        try {
            return jdbcTemplate.update(sql, email);
        } catch (DataAccessException e) {
            logger.error("error Inside deleteCustomer  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public List<CustomerDto> allCustomersData() {
        try {
            return jdbcTemplate.query("select * from customer", new RowMapper<CustomerDto>() {
                public CustomerDto mapRow(ResultSet rs, int row) throws SQLException {
                    CustomerDto customerDto = new CustomerDto();
                    customerDto.setFirstName(rs.getString(1));
                    customerDto.setLastName(rs.getString(2));
                    customerDto.setEmail(rs.getString(3));
                    customerDto.setPassword(rs.getString(4));
                    customerDto.setRePassword(rs.getString(5));
                    customerDto.setContact(rs.getString(6));
                    customerDto.setDob(rs.getString(7));
                    customerDto.setAddressLine1(rs.getString(8));
                    customerDto.setAddressLine2(rs.getString(9));
                    customerDto.setCity(rs.getString(10));
                    customerDto.setState(rs.getString(11));
                    customerDto.setPincode(rs.getString(12));
                    customerDto.setRole(rs.getString(13));
                    return customerDto;
                }
            });
        } catch (DataAccessException e) {
            logger.error("error Inside deleteCustomer  method at CustomerDaoImpl class" + e);
        }
        return null;
    }

    @Override
    public int placeOrderSave(CustomerDto customerDto) {
        String sql = "INSERT INTO placeorder(orderId,productId,email,addressLine1,pincode,contact,cod) " +
                "VALUES ('" + customerDto.getOrderId() + "','" + customerDto.getProductId() + "','" + customerDto.getEmail() + "','" + customerDto.getAddressLine1() + "','" + customerDto.getPincode() + "','" + customerDto.getContact() + "','" + customerDto.getCod() + "')";
        try {
            return jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("error inside placeOrderSave  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public CustomerDto getPlaceOrder(long orderId) {
        String sql = "select * from placeorder where email=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new BeanPropertyRowMapper<CustomerDto>(CustomerDto.class));
        } catch (DataAccessException e) {
            e.getStackTrace();
            logger.error("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public CustomerDto getCustomerFirstName(Principal principal) {
        String sql = "select firstName from customer where email='" + principal.getName() + "'";
        try {
            return (CustomerDto) getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(CustomerDto.class));
        } catch (DataAccessException e) {
            e.getStackTrace();
            logger.error("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public int emailCount(CustomerDto customerDto) {
        String query = "select count(*) from bookwarehouse.customer where email='" + customerDto.getEmail() + "'";
        try {
            int count = jdbcTemplate.queryForObject(query, Integer.class);
            if (count > 0) {
                return count;
            }
            return 0;
        } catch (DataAccessException e) {
            logger.error("error inside emailCount  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public int bookIdCount(BookDto bookDto) {
        String query = "select count(*) from bookwarehouse.book where bookId='" + bookDto.getBookId() + "'";
        try {
            int count = jdbcTemplate.queryForObject(query, Integer.class);
            if (count > 0) {
                return count;
            }
            return 0;
        } catch (DataAccessException e) {
            logger.error("error inside bookIdCount  method at CustomerDaoImpl class" + e);
        }
        return 0;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
