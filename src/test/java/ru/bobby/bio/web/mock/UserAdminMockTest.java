package ru.bobby.bio.web.mock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bobby.bio.model.Role;
import ru.bobby.bio.model.User;
import ru.bobby.bio.util.exception.NotFoundException;
import ru.bobby.bio.web.user.AdminUserRestController;

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
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminUserRestController.class);
    }

    @Test
    public void testCreate() {
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
