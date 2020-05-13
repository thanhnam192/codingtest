package com.announcingsystem.project.activities;

import com.announcingsystem.services.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("projectActivity")
public class PetProjectActivity implements ProjectActivity {
    private MessageService messageService;

    @Autowired
    public PetProjectActivity(MessageService messageService){
        this.messageService = messageService;
    }

    public String announceProject(String message) {
        return this.messageService.postMessage(message);
    }
}
