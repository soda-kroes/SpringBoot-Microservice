package com.soda.bank.helper;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ClsHelper {

    public String generateUniqueNumber() {
        // Generate a random number (for example, between 100000 and 999999)
        int randomNumber = ThreadLocalRandom.current().nextInt(100000, 1000000); // 6-digit number
        return String.valueOf(randomNumber);
    }
}
