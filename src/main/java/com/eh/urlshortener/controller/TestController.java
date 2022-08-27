package com.eh.urlshortener.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eh.urlshortener.helper.ApiResponse;
import com.eh.urlshortener.helper.constants.TestConstants;

/**
 *
 * @author Md. Emran Hossain
 * @since 27 Aug, 2022
 * @version 1.1
 */
@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    /**
     * This is a test api
     *
     * @author Md. Emran Hossain
     * @since  27 Aug, 2022
     */
    @GetMapping(TestConstants.TEST)
    @SuppressWarnings({ TestConstants.UNCHECKED, TestConstants.RAWTYPES })
    public ResponseEntity<?> getTest(){
        LOG.info(TestConstants.TEST_API_CALLED);
        return new ResponseEntity(new ApiResponse(true, TestConstants.SUCCESS), HttpStatus.OK);
    }
}
