package ru.bobby.web.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.bobby.web.LoggedUser;
import ru.bobby.web.model.User;
import ru.bobby.web.service.UserService;



/**
 * Created by b.istomin on 15.05.2015.
 */
@Controller
public class AdminUserRestController {

    private static Logger LOG = LoggerFactory.getLogger(AdminUserRestController.class);

    @Autowired
    private UserService service;

    public void update(User user) {
        int id = LoggedUser.id();
        LOG.info("update {}", user);
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
