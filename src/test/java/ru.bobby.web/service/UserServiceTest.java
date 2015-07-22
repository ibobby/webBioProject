package ru.bobby.web.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bobby.web.UserTestData.TestUser;
import ru.bobby.web.model.Role;
import ru.bobby.web.model.User;
import ru.bobby.web.util.DbPopulator;

import java.util.EnumSet;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    protected UserService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() {
        dbPopulator.execute();
    }

    @Test
    public void testSave() throws Exception {
        TestUser tu = new TestUser("New", "new@gmail.com", "newpass", true, EnumSet.of(Role.ROLE_USER));
        User created = service.save(tu.asUser());
        tu.setId(created.getId());

    }

}
