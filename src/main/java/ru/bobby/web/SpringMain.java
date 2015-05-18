package ru.bobby.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bobby.web.repository.mock.MockUserProceduresRepositoryImpl;
import ru.bobby.web.repository.mock.MockUserRepositoryImpl;

import java.util.Arrays;

/**
 * Created by bobby on 17.05.2015.
 */
public class SpringMain {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
           MockUserRepositoryImpl mockUserRepository = appCtx.getBean(MockUserRepositoryImpl.class);
        }
    }
}
