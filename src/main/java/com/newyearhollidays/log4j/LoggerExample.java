package com.newyearhollidays.log4j;

import org.apache.log4j.Logger;

public class LoggerExample {

    private  static final Logger log = Logger.getLogger(LoggerExample.class);

    public void doOrder(){
        System.out.println("Order ready");
        log.info("This information message");
        addToCart();
    }

    public void addToCart(){
        System.out.println("Order added");

        log.error("This error message");
    }
}
