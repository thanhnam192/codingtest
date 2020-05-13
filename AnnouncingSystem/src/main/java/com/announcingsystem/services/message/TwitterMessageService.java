package com.announcingsystem.services.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Component
public class TwitterMessageService implements MessageService {
    @Value("${twitter.consumer-key}")
    private String consumerKeyStr;

    @Value("${twitter.consumer-secret}")
    private String consumerSecretStr;

    @Value("${twitter.access-token}")
    private String accessTokenStr;

    @Value("${twitter.access-token-secret}")
    private String accessTokenSecretStr;

    private Logger logger = LoggerFactory.getLogger(TwitterMessageService.class);

    public String postMessage(String message) {
        if( tweetMessage(message) ){
            return "Tweet you message is successfully!";
        }

        return "Tweeting got error! Please try again later";
    }

    private boolean tweetMessage(String message){
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);
            twitter.setOAuthAccessToken(accessToken);
            twitter.updateStatus(message);
            return true;
        } catch (TwitterException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
