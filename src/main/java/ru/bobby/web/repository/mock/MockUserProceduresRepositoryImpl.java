package ru.bobby.web.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.repository.UserProceduresRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by bobby on 17.05.2015.
 */
@Repository
public class MockUserProceduresRepositoryImpl implements UserProceduresRepository {

    private static final Logger LOG = LoggerFactory.getLogger(MockUserProceduresRepositoryImpl.class);

    @Override
    public UserProcedures save(UserProcedures userProcedure, int userId) {
        LOG.info("save proc {} for user {}", userProcedure, userId);
        return userProcedure;
    }

    @Override
    public boolean delete(int id, int userId) {
        LOG.info("delete proc {} for user {}", id, userId);
        return true;
    }

    @Override
    public void deleteAll(int userId) {
        LOG.info("delete all proc for user {}", userId);
    }

    @Override
    public UserProcedures get(int id, int userId) {
        LOG.info("get proc for user ", id, userId);
        return null;
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        LOG.info("get all proc for user {}", userId);
        return Collections.emptyList();
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        LOG.info("get proc beteween {} and {} for user {}", startDate, endDate, userId);
        return Collections.emptyList();
    }
}
