package ru.bobby.bio.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bobby.bio.model.UserProcedures;
import ru.bobby.bio.util.DbPopulator;
import ru.bobby.bio.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;

import static ru.bobby.bio.ProcedureTestData.*;
import static ru.bobby.bio.model.UserProcedures.START_SEQ;

/**
 * Created by b.istomin on 31.07.2015.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserProceduresServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    UserProceduresService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() {
        dbPopulator.execute();
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(PROCEDURE1_ID, START_SEQ);
        MATCHER.assertListEquals(Arrays.asList(PROC4, PROC3, PROC2), service.getAll(START_SEQ));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        service.delete(PROCEDURE1_ID, 1);
    }

    @Test
    public void testSave() throws Exception {
        UserProcedures created = getCreated();
        service.save(created, START_SEQ);
        MATCHER.assertListEquals(Arrays.asList(created, PROC4, PROC3, PROC2, PROC1), service.getAll(START_SEQ));
    }

    @Test
    public void testGet() throws Exception {
        UserProcedures actual = service.get(PROCEDURE1_ID, START_SEQ);
        MATCHER.assertEquals(PROC1, actual);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        service.get(PROCEDURE1_ID, START_SEQ + 1);
    }

    @Test
    public void testUpdate() throws Exception {
        UserProcedures updated = getUpdated();
        service.update(updated, START_SEQ);
        MATCHER.assertEquals(updated, service.get(PROCEDURE1_ID, START_SEQ));
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundUpdate() throws Exception {
        UserProcedures item = service.get(PROCEDURE1_ID, START_SEQ);
        service.update(item, START_SEQ + 1);
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertListEquals(Arrays.asList(PROC4, PROC3, PROC2, PROC1), service.getAll(START_SEQ));
    }

    @Test
    public void testGetBetween() throws Exception {
        MATCHER.assertListEquals(Arrays.asList(PROC2, PROC1),
                service.getBetween(START_SEQ, LocalDateTime.of(2015, 1, 6, 8, 0), LocalDateTime.of(2015, 1, 6, 14, 0)));
    }

    @Test
    public void testDeleteAll() {
        service.deleteAll(START_SEQ);
        Assert.assertEquals(0, service.getAll(START_SEQ).size());
    }

}
