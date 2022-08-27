package com.eh.urlshortener.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eh.urlshortener.helper.RandomGen;
import com.eh.urlshortener.helper.constants.CommonConstants;
import com.eh.urlshortener.helper.constants.MainConstants;
import com.eh.urlshortener.model.URL;

@Controller
public class MainController {

    @SuppressWarnings(CommonConstants.UNUSED)
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    private Map<String, URL> urlList = new HashMap<>();

    @Autowired
    RandomGen randomGen;

    /**
     * This request load index file
     *
     * @author Md. Emran Hossain
     * @since  27 Aug, 2022
     */
    @GetMapping(MainConstants.HOME)
    public String loadHome(){
        return MainConstants.INDEX;
    }

    /**
     * This api for Short url
     *
     * @author Md. Emran Hossain
     * @since  27 Aug, 2022
     */
    @PostMapping(value=MainConstants.SHORTEN_URL)
    public ResponseEntity<Object> getShortenUrl(@RequestBody URL url) throws MalformedURLException {
        String randomChar = randomGen.randomChars();
        setShortUrl(randomChar, url);
        return new ResponseEntity<Object>(url, HttpStatus.OK);
    }

    /**
     * This api for redirect url
     *
     * @author Md. Emran Hossain
     * @since  27 Aug, 2022
     */
    @GetMapping(value=MainConstants.SHORT_CHAR)
    public void getFullUrl(HttpServletResponse response, @PathVariable("urls") String randomString) throws IOException {
        response.sendRedirect(urlList.get(randomString).getFullUrl());
    }

    private void setShortUrl(String randomChar, URL url) throws MalformedURLException {
         url.setShortUrl(MainConstants.RANDOM + randomChar);
         urlList.put(randomChar, url);
    }
}
