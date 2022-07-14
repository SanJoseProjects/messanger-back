package ru.cft.messenger.repository;

import ru.cft.messenger.repository.model.Users;
import java.util.List;

public interface UserRepository {

    List<Users> selectAll();

    Users findByLogin(String login);

    Users findById(Long userId);

    List<Users> findByName(String name);

    void save(Users user);
}
