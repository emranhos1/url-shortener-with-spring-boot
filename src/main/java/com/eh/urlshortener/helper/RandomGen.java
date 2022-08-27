package com.eh.urlshortener.helper;

import org.springframework.stereotype.Component;

import com.eh.urlshortener.helper.constants.CommonConstants;

@Component
public class RandomGen {

    /**
     * This method gererate random char
     *
     * @author Md. Emran Hossain
     * @since  27 Aug, 2022
     */
    public String randomChars() {
        String randomStr = "";
        String possibleChars = CommonConstants.CHARS;
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }
}
