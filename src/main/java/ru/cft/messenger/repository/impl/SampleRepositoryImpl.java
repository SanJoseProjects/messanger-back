package ru.cft.messenger.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.messenger.repository.UserRepository;
import ru.cft.messenger.repository.model.User;
import java.util.List;
import java.util.Optional;

@Repository
public class SampleRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper;

    @Autowired
    public SampleRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<User> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<User> selectAll() {
        return jdbcTemplate.query("Select * from users;", rowMapper);
    }
}
