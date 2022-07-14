package ru.cft.messenger.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.messenger.repository.model.Message;
import ru.cft.messenger.repository.model.Role;
import ru.cft.messenger.repository.model.Status;
import ru.cft.messenger.repository.model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MessageEntityRowMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message result = new Message();
        result.setId(rs.getLong("id"));
        result.setMessage(rs.getString("message"));
        result.setSenderId(rs.getLong("sender_id"));
        result.setReceiverId(rs.getLong("receiver_id"));

        return result;
    }
}
