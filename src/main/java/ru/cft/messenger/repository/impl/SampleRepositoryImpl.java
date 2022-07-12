package ru.cft.messenger.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.messenger.repository.UserRepository;
import ru.cft.messenger.repository.model.Users;
import java.util.List;

@Repository
public class SampleRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Users> rowMapper;

    @Autowired
    public SampleRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Users> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Users> selectAll() {
        return jdbcTemplate.query("Select * from users;", rowMapper);
    }

    @Override
    public Users findByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject("Select * from users WHERE login = ?;", rowMapper, login);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Users findById(Long userId) {
        return jdbcTemplate.queryForObject("Select * from users WHERE id = ?;", rowMapper, userId);
    }

    @Override
    public void save(Users user) {
        jdbcTemplate.update("INSERT INTO users (login, password, name, role, status) VALUES (?, ?, ?, ?, ?)",
                user.getLogin(), user.getPassword(), user.getName(), "USER", "ACTIVE");
    }

}
