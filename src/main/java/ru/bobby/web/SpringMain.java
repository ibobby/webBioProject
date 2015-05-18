package ru.bobby.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.repository.mock.MockUserProceduresRepositoryImpl;
import ru.bobby.web.repository.mock.MockUserRepositoryImpl;
import ru.bobby.web.service.UserService;
import ru.bobby.web.service.UserServiceImpl;

import java.util.Arrays;

/**
 * Created by bobby on 17.05.2015.
 */
public class SpringMain {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
            UserServiceImpl userServiceImpl = appCtx.getBean(UserServiceImpl.class);
            System.out.println(userServiceImpl.getRepository());
        }
    }
}
