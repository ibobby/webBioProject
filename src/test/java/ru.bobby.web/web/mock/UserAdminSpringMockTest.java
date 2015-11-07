package ru.bobby.web.web.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bobby.web.model.Role;
import ru.bobby.web.model.User;
import ru.bobby.web.util.exception.NotFoundException;
import ru.bobby.web.web.user.AdminUserRestController;

import java.util.EnumSet;

/**
 * Created by b.istomin on 26.05.2015.
 */
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {

    @Autowired
    AdminUserRestController controller;

    @Test
    public void create() {
        controller.create(new User(5, "sunny", "sunny@com", "555", true, EnumSet.of(Role.ROLE_USER)));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() {
        controller.delete(0);
    }

    @Test
    public void testDelete() {
        controller.delete(5);
    }
}
