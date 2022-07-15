package ru.cft.messenger.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.messenger.repository.UserRepository;
import ru.cft.messenger.repository.model.Role;
import ru.cft.messenger.repository.model.Status;
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
        try {
            return jdbcTemplate.query("Select id,login,name from users;", (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setName(rs.getString("name"));

                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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
        try {
            return jdbcTemplate.queryForObject("Select id,login,name from users WHERE id = ?;", (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setName(rs.getString("name"));

                return user;
            }, userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Users user) {
        String role = user.getRole() == Role.USER ? "USER" : "ADMIN";
        String status = user.getStatus() == Status.ACTIVE ? "ACTIVE" : "BANNED";

        jdbcTemplate.update("INSERT INTO users (login, password, name, role, status) VALUES (?, ?, ?, ?, ?)",
                user.getLogin(), user.getPassword(), user.getName(), role, status);
    }

    @Override
    public List<Users> findByName(String name) {
        try {
            return jdbcTemplate.query("Select id,login,name from users WHERE name = ?;", (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setName(rs.getString("name"));

                return user;
            }, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
