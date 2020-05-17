package com.announcingsystem.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.announcingsystem.ApplicationDemo;
import com.announcingsystem.project.activities.ProjectActivity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

public class AnnounceProjectApi implements RequestHandler<HandlerRequest, HandlerResponse> {
    public HandlerResponse handleRequest(HandlerRequest handlerRequest, Context context) {
        String result = "";
        final String message = handlerRequest.getMessage();

        if( !StringUtils.isEmpty(message) ){
            AnnotationConfigApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(ApplicationDemo.class);
            ProjectActivity systemActivity = applicationContext.getBean("projectActivity", ProjectActivity.class);

            result = systemActivity.announceProject(message);
            applicationContext.close();
        }


        return new HandlerResponse(result);
    }
}
