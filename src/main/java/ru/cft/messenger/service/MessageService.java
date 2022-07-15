package ru.cft.messenger.service;

import ru.cft.messenger.repository.model.Message;

public interface MessageService {

    Message getMessageById(Long id);

    void addMessage(Message message);
}
