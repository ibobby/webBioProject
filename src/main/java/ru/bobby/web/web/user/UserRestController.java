package ru.bobby.web.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.bobby.web.LoggedUser;
import ru.bobby.web.model.User;
import ru.bobby.web.service.UserService;

import java.util.Collections;
import java.util.List;

import static ru.bobby.web.LoggedUser.*;

/**
 * Created by b.istomin on 15.05.2015.
 */
@Controller
public class UserRestController {

    private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService service;

    public void update(User user) {
        int id = LoggedUser.id();
        LOG.info("save {}", user);
        service.update(user);
    }

    public void delete() {
        int id = LoggedUser.id();
        LOG.info("delete {}", id);
        service.delete(id);
    }

    public void get() {
        int id = LoggedUser.id();
        LOG.info("get {}", id);
        service.get(id);
    }
}
