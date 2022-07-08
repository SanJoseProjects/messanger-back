package ru.cft.messenger.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.messenger.repository.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserEntityRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User result = new User();
        result.id = rs.getLong("id");
        result.login = rs.getString("login");
        result.password = rs.getString("password");
        result.name = rs.getString("name");
        result.surname = rs.getString("surname");
        return result;
    }
}
