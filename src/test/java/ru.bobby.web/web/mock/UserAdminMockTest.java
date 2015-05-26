package ru.bobby.web.web.mock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bobby.web.model.Role;
import ru.bobby.web.model.User;
import ru.bobby.web.util.exception.NotFoundException;
import ru.bobby.web.web.user.AdminUserRestController;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * Created by b.istomin on 26.05.2015.
 */
public class UserAdminMockTest {

    public static ConfigurableApplicationContext appCtx;
    public static AdminUserRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminUserRestController.class);
    }

    @Test
    public void create() {
        User bob = new User(5, "bob", "bob@gmail.com", "1", true, EnumSet.of(Role.ROLE_USER));
        controller.create(bob);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() {
        controller.delete(0);
    }

    @Test
    public void testDelete() {
        controller.delete(7);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }

}
