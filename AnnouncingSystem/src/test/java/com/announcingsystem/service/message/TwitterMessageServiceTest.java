package com.announcingsystem.service.message;

import com.announcingsystem.services.message.TwitterMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TwitterMessageService.class)
public class TwitterMessageServiceTest {

    public static final String SUCCESS_MESSAGE = "Tweet you message is successfully!";
    public static final String ERROR_MESSAGE = "Tweeting got error! Please try again later";
    public static final String TWEET_MESSAGE_METHOD = "tweetMessage";
    public static final String MESSAGE_SUCCESS = "MESSAGE";
    public static final String MESSAGE_ERROR = "error";

    @Test
    public void should_return_correct_success_message_when_tweet_successfully() throws Exception {
        final TwitterMessageService spy = PowerMockito.spy(new TwitterMessageService());
        PowerMockito.doReturn(true).when(spy, TWEET_MESSAGE_METHOD, MESSAGE_SUCCESS);

        String successResultMessage = spy.postMessage(MESSAGE_SUCCESS);
        Assert.assertEquals(SUCCESS_MESSAGE, successResultMessage);

    }

    @Test
    public void should_return_correct_error_message_when_tweet_failed() throws Exception {
        final TwitterMessageService spy = PowerMockito.spy(new TwitterMessageService());
        PowerMockito.doReturn(false).when(spy, TWEET_MESSAGE_METHOD, MESSAGE_ERROR);

        String errorResultMessage = spy.postMessage(MESSAGE_ERROR);
        Assert.assertEquals(ERROR_MESSAGE, errorResultMessage);

    }
}
