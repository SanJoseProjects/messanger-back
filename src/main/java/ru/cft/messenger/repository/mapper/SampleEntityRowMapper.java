package ru.cft.messenger.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.messenger.repository.model.SampleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SampleEntityRowMapper implements RowMapper<SampleEntity> {
    @Override
    public SampleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        SampleEntity result = new SampleEntity();
        result.id = rs.getLong("id");
        result.login = rs.getString("login");
        result.password = rs.getString("password");
        result.name = rs.getString("name");
        result.surname = rs.getString("surname");
        return result;
    }
}
