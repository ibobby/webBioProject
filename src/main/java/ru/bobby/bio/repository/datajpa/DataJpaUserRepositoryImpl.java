package ru.bobby.bio.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.bobby.bio.model.User;
import ru.bobby.bio.repository.UserRepository;

import java.util.List;

/**
 * Created by b.istomin on 30.01.2016.
 */
@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    @Autowired
    private ProxyUserRepository proxy;

    @Override
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return proxy.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll(SORT_NAME_EMAIL);
    }
}
