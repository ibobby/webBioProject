package ru.bobby.bio.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bobby.bio.model.User;

import java.util.List;


/**
 * Created by b.istomin on 15.05.2015.
 */
@RestController
@RequestMapping("rest/admin/users")
public class AdminUserRestController {

    private static Logger LOG = LoggerFactory.getLogger(AdminUserRestController.class);

    @Autowired
    private UserHelper helper;

    public void create(User user) {
        helper.create(user);
    }

    public void update(User user) {
        helper.update(user);
    }

    public void delete(int id) {
        helper.delete(id);
    }

    public void get(int id) {
        helper.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public List<User> getAll() {
        return helper.getAll();
    }

    public User getByEmail(String email) {
        return helper.getByMail(email);
    }
}
