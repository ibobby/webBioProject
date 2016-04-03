package ru.bobby.bio.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bobby.bio.model.User;
import ru.bobby.bio.service.UserService;

import java.util.List;

/**
 * Created by b.istomin on 15.03.2016.
 */
@Component
public class UserHelper {

    private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        LOG.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user) {
        LOG.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

}
