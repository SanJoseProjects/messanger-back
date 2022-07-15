package ru.cft.messenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.messenger.repository.UserRepository;
import ru.cft.messenger.repository.model.Users;
import ru.cft.messenger.service.SampleService;
import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    private final UserRepository sampleRepository;

    @Autowired
    public SampleServiceImpl(UserRepository userRepository) {
        this.sampleRepository = userRepository;
    }

    @Override
    public List<Users> getAllSample() {
        return sampleRepository.selectAll();
    }

    @Override
    public Users findByLogin(String login) { return sampleRepository.findByLogin(login); }

    @Override
    public List<Users> findByName(String name) { return sampleRepository.findByName(name); }

    @Override
    public Users findById(Long userId) { return sampleRepository.findById(userId); }
}
