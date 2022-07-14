package ru.cft.messenger.repository;

import ru.cft.messenger.repository.model.Message;

public interface MessageRepository {
    Message getMessageById(Long id);

    void setMessage(Message message);
}
