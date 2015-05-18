package ru.bobby.web.web.procedure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.bobby.web.LoggedUser;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.service.UserProceduresService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 15.05.2015.
 */
@Controller
public class UserProceduresRestController {

    private static final Logger LOG = LoggerFactory.getLogger(UserProceduresRestController.class);

    @Autowired
    private UserProceduresService service;

    public UserProcedures save(UserProcedures userProcedure) {
        int userId = LoggedUser.id();
        LOG.info("save procedure {} for user {}", userProcedure, userId);
        return service.save(userProcedure, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete procedure {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public void deleteAll() {
        int userId = LoggedUser.id();
        LOG.info("delete all procedures for user {}", userId);
        service.deleteAll(userId);
    }

    public UserProcedures get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get procedure {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public List<UserProcedures> getAll() {
        int userId = LoggedUser.id();
        LOG.info("get all procedures for user {}", userId);
        return service.getAll(userId);
    }

    public List<UserProcedures> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.id();
        LOG.info("get procedures for user {} between {} and {}", userId, startDate, endDate);
        return service.getBetween(userId, startDate, endDate);
    }

}
