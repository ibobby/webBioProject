package ru.bobby.web.repository.jdbc;

import ru.bobby.web.model.User;
import ru.bobby.web.repository.UserRepository;

import java.util.List;

/**
 * Created by b.istomin on 16.06.2015.
 */
public class JdbcUserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
