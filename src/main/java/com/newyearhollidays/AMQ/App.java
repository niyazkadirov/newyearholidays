package com.newyearhollidays.AMQ;

import org.apache.log4j.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        LOGGER.info("Starting " + Producer.class );
        new Producer().start();

        LOGGER.info("Starting " + Consumer.class );
        new Consumer().start();

//        LOGGER.info("Starting " + ObjectProducer.class );
//        new ObjectProducer().start();
//
//        LOGGER.info("Starting " + ObjectConsumer.class );
//        new ObjectConsumer().start();
    }
}
