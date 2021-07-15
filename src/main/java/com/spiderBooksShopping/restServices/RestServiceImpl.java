package com.spiderBooksShopping.restServices;

import com.spiderBooksShopping.controller.CustomerController;
import com.spiderBooksShopping.dto.BookDto;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RestServiceImpl implements RestService {

    private RestTemplate restTemplate;

    //Constant
    private static String REST_SERVICE_URL="http://localhost:8081/SpiderBookWarehouse_war_exploded/";

    private static Logger logger = LogManager.getLogger(RestServiceImpl.class);

    @Override
    public List<BookDto> getRestProduct() {
        String url =  REST_SERVICE_URL+"getAllBooksDataInJson";
        try {
            ResponseEntity<BookDto[]> reponse = getRestTemplate().getForEntity(url, BookDto[].class);
            if (reponse.getBody() != null) {
                return Arrays.asList(reponse.getBody());
            }
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall inside getRestProduct method at RestServiceImpl class" + e);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public BookDto getBookByBookId(String bookId) {
        String url =  REST_SERVICE_URL+"getSingleBookJson/"+bookId;
        try {
            BookDto bookDto = restTemplate.getForObject(url, BookDto.class);
            return bookDto;
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall Inside getBookByBookId method at RestServiceImpl class" + e);
        }
        return null;
    }

    @Override
    public int deleteBookByBookId(String bookId) {
        String url =  REST_SERVICE_URL+"deleteTheBookToJson/"+bookId;
        try {
            restTemplate.getForObject(url, Integer.class);
            return 1;
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall Inside deleteBookByBookId method at RestServiceImpl class" + e);
        }
        return 0;
    }

    @Override
    public int clientSideBookAddToServerSide(BookDto bookDto) {
        String url =  REST_SERVICE_URL+"addBookToJson";
        try {
            restTemplate.postForEntity(url, bookDto, Integer.class);
            return 1;
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall Inside clientSideBookAddToServerSide method at RestServiceImpl class" + e);
        }
        return 0;
    }

    @Override
    public int clientSideBookUpdateToServerSide(BookDto bookDto) {
        String url = REST_SERVICE_URL+"updateTheBookToJson";
        try {
            restTemplate.postForEntity(url, bookDto, Integer.class);
            return 1;
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall Inside clientSideBookUpdateToServerSide method at RestServiceImpl class" + e);
        }
        return 0;
    }

    @Override
    public List<BookDto> getSellerNameBooksData(String email) {
        String url = REST_SERVICE_URL+"getSellerNameBooksDataToJson/" + email;
        try {
            ResponseEntity<BookDto[]> reponse = getRestTemplate().getForEntity(url, BookDto[].class);
            if (reponse.getBody() != null) {
                return Arrays.asList(reponse.getBody());
            }
        } catch (RestClientException e) {
            logger.error("Exception While Making RestCall Inside getSellerNameBooksData method at RestServiceImpl class" + e);
        }
        return Collections.EMPTY_LIST;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
