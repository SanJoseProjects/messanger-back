package ru.cft.messenger.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.messenger.repository.SampleRepository;
import ru.cft.messenger.repository.model.SampleEntity;

import java.util.List;

@Repository
public class SampleRepositoryImpl implements SampleRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<SampleEntity> rowMapper;

    @Autowired
    public SampleRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<SampleEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<SampleEntity> selectAll() {
        return jdbcTemplate.query("Select * from sample;", rowMapper);
    }

    public void setSampleEntity(SampleEntity entity) { jdbcTemplate.query("INSERT INTO sample(id, login, name, password, surname)", rowMapper); }
}
