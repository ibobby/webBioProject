package ru.bobby.web.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bobby.web.model.User;
import ru.bobby.web.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;

/**
 * Created by bobby on 17.05.2015.
 */
//@Repository
public class MockUserRepositoryImpl implements UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepositoryImpl.class);

    @PostConstruct
    public void postConstruct() {
        LOG.info("PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        LOG.info("PreDestroy");
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return id != 0;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("get by email " + email);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("get all users");
        return Collections.emptyList();
    }
}
