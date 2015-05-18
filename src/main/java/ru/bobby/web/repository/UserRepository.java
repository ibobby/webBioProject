package ru.bobby.web.repository;

import ru.bobby.web.model.User;

import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

}
