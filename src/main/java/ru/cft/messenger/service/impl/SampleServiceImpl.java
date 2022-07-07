package ru.cft.messenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.messenger.repository.SampleRepository;
import ru.cft.messenger.repository.model.SampleEntity;
import ru.cft.messenger.service.SampleService;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public List<SampleEntity> getAllSample() {
        return sampleRepository.selectAll();
    }
}
