package com.spiderBooksShopping.dao;

import com.spiderBooksShopping.controller.CustomerController;
import com.spiderBooksShopping.dto.BookCartDto;
import com.spiderBooksShopping.dto.BookDto;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookCartDaoImpl implements BookCartDao {

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveBookCart(BookCartDto bookCartDto) {
        BasicConfigurator.configure();
        String sql = "INSERT INTO bookcart(cartId,userId,bookId,price,quantity,subTotal) " +
                "VALUES ('" + bookCartDto.getCartId() + "','" +bookCartDto.getUserId()+ "','" +bookCartDto.getBookId()+ "','" +bookCartDto.getPrice()+ "','" +bookCartDto.getQuantity()+ "','" +bookCartDto.getSubTotal()+ "')";
        try {
            return jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("Inside saveBook method at BookDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public BookCartDto getCartBook(int cartId) {
        String sql = "select * from bookcart where cartId=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cartId}, new BeanPropertyRowMapper<BookCartDto>(BookCartDto.class));
        } catch (DataAccessException e) {
            logger.error("Inside getBook method at BookDaoImpl class" + e);
        }
        return null;
    }

    @Override
    public int updateBookCart(BookCartDto bookCartDto) {
        String sql = "UPDATE bookcart SET quantity='" + bookCartDto.getQuantity() + "' where cartId='"
                + bookCartDto.getCartId()+ "'";
        try {
            return jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("Inside updateBook method at BookDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public int deleteBookCart(int cartId) {
        String sql = "delete from bookcart where cartId=?";
        try {
            return jdbcTemplate.update(sql, cartId);
        } catch (DataAccessException e) {
            logger.error("Inside deleteBook method at BookDaoImpl class" + e);
        }
        return 0;
    }

    @Override
    public List<BookCartDto> allBookCartData(String userId) {
        return jdbcTemplate.query("select * from bookcart where userId='"+userId+"'", new RowMapper<BookCartDto>() {
            public BookCartDto mapRow(ResultSet rs, int row) throws SQLException {
                BookCartDto bookCartDto = new BookCartDto();
                bookCartDto.setCartId(rs.getInt(1));
                bookCartDto.setUserId(rs.getString(2));
                bookCartDto.setBookId(rs.getString(3));
                bookCartDto.setPrice(rs.getDouble(4));
                bookCartDto.setQuantity(rs.getInt(5));
                bookCartDto.setSubTotal(rs.getDouble(6));
                return bookCartDto;
            }
        });
    }



    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
