package ru.cft.messenger.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.messenger.repository.MessageRepository;
import ru.cft.messenger.repository.model.Message;
import ru.cft.messenger.repository.model.Users;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Message> rowMapper;

    @Autowired
    public MessageRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Message> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public Message getMessageById(Long id) { return jdbcTemplate.queryForObject(
            "Select * from message WHERE id = ?", rowMapper, id); }

    @Override
    public void setMessage(Message message) {
        jdbcTemplate.update("INSERT INTO message (message, sender_id, receiver_id) VALUES (?, ?, ?)",
        message.getMessage(), message.getSenderId(), message.getReceiverId());
    }
}
