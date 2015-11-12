package ru.bobby.bio.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.bobby.bio.model.User;
import ru.bobby.bio.service.UserService;



/**
 * Created by b.istomin on 15.05.2015.
 */
@Controller
public class AdminUserRestController {

    private static Logger LOG = LoggerFactory.getLogger(AdminUserRestController.class);

    @Autowired
    private UserService service;

    public void create(User user) {
        LOG.info("create {}", user);
        service.save(user);
    }

    public void update(User user) {
        LOG.info("update {}", user);
        service.update(user);
    }

    public void delete(int id) {
        LOG.info("delete {}", id);
        service.delete(id);
    }

    public void get(int id) {
        LOG.info("get {}", id);
        service.get(id);
    }
}