package ru.cft.messenger.service;

import org.springframework.stereotype.Service;
import ru.cft.messenger.repository.model.Users;
import java.util.List;
public interface SampleService {

    List<Users> getAllSample();

    Users findByLogin(String login);
    List<Users> findByName(String name);
    Users findById(Long userId);
}
