package com.announcingsystem.project.activities;

import com.announcingsystem.services.message.MessageService;
import com.announcingsystem.services.message.TwitterMessageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class PetProjectActivityTest {
    private static final String SUCCESS_MESSAGE = "SUCCESS_MESSAGE";
    private static final String ERROR_MESSAGE = "ERROR_MESSAGE";
    private static final String SUCCESS_RESULT = "Tweet you message is successfully!";
    private static final String ERROR_RESULT = "Some errors occur when you tweet a message";

    @Autowired
    MessageService messageService;

    @Autowired
    ProjectActivity projectActivity;

    @Configuration
    static class ContextConfiguration {
        @Bean
        public MessageService twitterMessageService() {

            return Mockito.mock(TwitterMessageService.class);
        }

        @Bean
        public ProjectActivity petProjectActivity(){
            return new PetProjectActivity(twitterMessageService());
        }
    }


    @Before
    public void setUp(){
        Mockito.when(messageService.postMessage(SUCCESS_MESSAGE)).thenReturn(SUCCESS_RESULT);
        Mockito.when(messageService.postMessage(ERROR_MESSAGE)).thenReturn(ERROR_RESULT);
    }

    @Test
    public void should_return_correct_success_message_when_tweet_success() {
        String successMessageResult = projectActivity.announceProject(SUCCESS_MESSAGE);
        Assert.assertEquals(SUCCESS_RESULT, successMessageResult);
    }

    @Test
    public void should_return_correct_error_message_when_tweet_failed() {
        String errorMessageResult = projectActivity.announceProject(ERROR_MESSAGE);
        Assert.assertEquals(ERROR_RESULT, errorMessageResult);
    }
}
