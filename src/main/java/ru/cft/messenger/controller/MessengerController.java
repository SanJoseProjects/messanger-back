package ru.cft.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.messenger.service.MessengerService;

@RestController
@RequestMapping("api/messenger")
public class MessengerController {

    private final MessengerService yellowRubberDuckService;

    @Autowired
    public MessengerController(MessengerService messengerService) {
        this.yellowRubberDuckService = messengerService;
    }
}
