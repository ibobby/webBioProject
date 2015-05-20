package ru.bobby.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.repository.UserProceduresRepository;
import ru.bobby.web.util.exception.ExceptionUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 15.05.2015.
 */
@Service
public class UserProceduresServiceImpl implements UserProceduresService {

    @Autowired
    private UserProceduresRepository repository;

    @Override
    public UserProcedures save(UserProcedures userProcedure, int userId) {
        return repository.save(userProcedure, userId);
    }

    @Override
    public UserProcedures update(UserProcedures userProcedure, int userId) {
        return ExceptionUtil.check(repository.save(userProcedure, userId), "proc " + userProcedure.getDescription() + " for user " + userId);
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.check(repository.delete(id, userId), "id = " + id + " user id = " + userId);
    }

    @Override
    public void deleteAll(int userId) {
        repository.deleteAll(userId);
    }

    @Override
    public UserProcedures get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), "id = " + id + " user id = " + userId);
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        return repository.getBetween(userId, startDate, endDate);
    }
}
