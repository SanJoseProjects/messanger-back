package ru.cft.messenger.service;

import ru.cft.messenger.repository.model.Users;
import java.util.List;

public interface SampleService {

    List<Users> getAllSample();

    Users findByLogin(String login);

    Users findById(Long userId);

    List<Users> findByName(String name);
}
