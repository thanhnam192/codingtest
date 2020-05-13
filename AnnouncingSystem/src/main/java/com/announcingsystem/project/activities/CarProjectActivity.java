package com.announcingsystem.project.activities;

import com.announcingsystem.services.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class CarProjectActivity implements ProjectActivity {
    private MessageService messageService;

    @Autowired
    public CarProjectActivity(MessageService messageService){
        this.messageService = messageService;
    }

    public String announceProject(String message) {
        //TODO - Do somethings else

        return this.messageService.postMessage(message);
    }
}
