package ru.cft.messenger.repository;

import ru.cft.messenger.repository.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> selectAll();

}
