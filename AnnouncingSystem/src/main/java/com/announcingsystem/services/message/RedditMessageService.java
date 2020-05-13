package com.announcingsystem.services.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class RedditMessageService implements MessageService{
    @Value("${reddit.consumer-key}")
    private String consumerKeyStr;

    @Value("${reddit.consumer-secret}")
    private String consumerSecretStr;

    @Value("${reddit.access-token}")
    private String accessTokenStr;

    @Value("${reddit.access-token-secret}")
    private String accessTokenSecretStr;

    private Logger logger = LoggerFactory.getLogger(RedditMessageService.class);

    public String postMessage(String message) {
        try {
            logger.info("Reddit - post a message : " + message);
            return "Reddit you message is successfully!";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Reddit got error! Please try again later,=.";
        }


    }
}
