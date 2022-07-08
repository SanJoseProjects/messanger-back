package ru.cft.messenger.repository;

import ru.cft.messenger.repository.model.User;
import java.util.List;

public interface UserRepository {

    List<User> selectAll();

}
