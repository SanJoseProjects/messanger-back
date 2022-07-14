package ru.cft.messenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.messenger.repository.MessageRepository;
import ru.cft.messenger.repository.model.Message;
import ru.cft.messenger.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getMessageById(Long id) { return messageRepository.getMessageById(id); }

    @Override
    public void addMessage(Message message) { messageRepository.setMessage(message); }
}
