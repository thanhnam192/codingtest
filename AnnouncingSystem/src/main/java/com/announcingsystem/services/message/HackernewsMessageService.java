package com.announcingsystem.services.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class HackernewsMessageService implements MessageService{
    @Value("${hackernews.consumer-key}")
    private String consumerKeyStr;

    @Value("${hackernews.consumer-secret}")
    private String consumerSecretStr;

    @Value("${hackernews.access-token}")
    private String accessTokenStr;

    @Value("${hackernews.access-token-secret}")
    private String accessTokenSecretStr;

    private Logger logger = LoggerFactory.getLogger(HackernewsMessageService.class);

    public String postMessage(String message) {
        try {
            logger.info("Hackernews - Post Message: Processing");

            //TODO Implement service to post message to Reddit

            logger.info("Hackernews - Post Message: Success");

            return "hackernews you message is successfully!";
        } catch (Exception e) {
            logger.info("Hackernews - Post Message: Failed");
            logger.error(e.getMessage());
            return "hackernews got error! Please try again later,=.";
        }


    }
}
