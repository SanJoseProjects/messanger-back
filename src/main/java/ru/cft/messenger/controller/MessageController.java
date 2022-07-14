package ru.cft.messenger.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.messenger.repository.model.Message;
import ru.cft.messenger.service.MessageService;

@RestController
@RequestMapping("api/message")
@Tag(name="Message", description = "Interact with message API")
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService messengerService) {
        this.service = messengerService;
    }

    @GetMapping("get/{id}")
    public Message getMessageById(@PathVariable Long id) { return service.getMessageById(id); }

    @PostMapping("get/")
    public void setMessage(@RequestBody Message message) { service.addMessage(message); }

}
