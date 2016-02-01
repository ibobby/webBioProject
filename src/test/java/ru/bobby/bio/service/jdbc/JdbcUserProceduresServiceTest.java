package ru.bobby.bio.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.bobby.bio.service.UserProceduresServiceTest;

import static ru.bobby.bio.Profiles.JDBC;
import static ru.bobby.bio.Profiles.POSTGRES;

/**
 * Created by b.istomin on 01.02.2016.
 */
@ActiveProfiles({JDBC, POSTGRES})
public class JdbcUserProceduresServiceTest extends UserProceduresServiceTest {
}
