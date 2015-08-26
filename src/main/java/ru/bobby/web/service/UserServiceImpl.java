package ru.bobby.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bobby.web.model.User;
import ru.bobby.web.repository.UserRepository;
import ru.bobby.web.util.exception.ExceptionUtil;
import ru.bobby.web.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    @Override
    public User save(User user) throws NotFoundException {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.check(repository.getByEmail(email), email);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
        ExceptionUtil.check(repository.save(user), user.getId());
    }
}
