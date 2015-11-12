package ru.bobby.bio.service;

import ru.bobby.bio.model.User;
import ru.bobby.bio.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by b.istomin on 15.05.2015.
 */
public interface UserService {

    public User save(User user) throws NotFoundException;

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    public User getByEmail(String email) throws NotFoundException;

    public List<User> getAll();

    public void update(User user) throws NotFoundException;

}
