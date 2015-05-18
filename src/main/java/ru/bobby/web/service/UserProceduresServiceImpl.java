package ru.bobby.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.repository.UserProceduresRepository;

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
        return null;
    }

    @Override
    public void delete(int id, int userId) {

    }

    @Override
    public void deleteAll(int userId) {

    }

    @Override
    public UserProcedures get(int id, int userId) {
        return null;
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        return null;
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }
}
