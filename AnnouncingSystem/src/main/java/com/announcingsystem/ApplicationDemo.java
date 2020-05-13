package com.announcingsystem;

import com.announcingsystem.project.activities.ProjectActivity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.announcingsystem")
@PropertySource("classpath:application.properties")
public class ApplicationDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationDemo.class);

        ProjectActivity systemActivity = context.getBean("projectActivity", ProjectActivity.class);


        System.out.println(systemActivity.announceProject("Hello World! My Name is Nam Nguyen"));
        context.close();
    }
}
