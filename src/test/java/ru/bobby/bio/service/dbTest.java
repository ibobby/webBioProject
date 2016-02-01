package ru.bobby.bio.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bobby.bio.util.DbPopulator;

/**
 * Created by b.istomin on 01.02.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

//@ActiveProfiles({JDBC, POSTGRES}) - moved to each technology path
@RunWith(SpringJUnit4ClassRunner.class)
abstract public class dbTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    protected UserService service;

    @Autowired
    protected DbPopulator dbPopulator;

    @Before
    public void setUp() {
        dbPopulator.execute();
    }
}
