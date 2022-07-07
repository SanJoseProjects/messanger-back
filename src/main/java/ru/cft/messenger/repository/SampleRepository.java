package ru.cft.messenger.repository;

import ru.cft.messenger.repository.model.SampleEntity;

import java.util.List;

public interface SampleRepository {

    public List<SampleEntity> selectAll();

}
