package ru.bobby.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bobby.web.model.User;
import ru.bobby.web.repository.UserRepository;
import ru.bobby.web.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    public UserRepository getRepository() {
        return repository;
    }

    @Autowired
    private UserRepository repository;

    @Override
    public User save(int id) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {

    }
}
