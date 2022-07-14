package ru.cft.messenger.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.cft.messenger.repository.model.Message;

public interface MessageService {
    Message getMessageById(Long id);

    void addMessage(Message message);
}
