package ru.cft.messenger.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.messenger.repository.model.Role;
import ru.cft.messenger.repository.model.Status;
import ru.cft.messenger.repository.model.Users;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserEntityRowMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users result = new Users();
        result.setId(rs.getLong("id"));
        result.setLogin(rs.getString("login"));
        result.setPassword(rs.getString("password"));
        result.setName(rs.getString("name"));
        if(rs.getString("role").equals("ADMIN"))
            result.setRole(Role.ADMIN);
        else
            result.setRole(Role.USER);
        if(rs.getString("status").equals("ACTIVE"))
            result.setStatus(Status.ACTIVE);
        else
            result.setStatus(Status.BANNED);
        return result;
    }
}
