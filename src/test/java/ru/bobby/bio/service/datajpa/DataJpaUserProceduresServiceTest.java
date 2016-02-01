package ru.bobby.bio.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.bobby.bio.service.UserProceduresServiceTest;

import static ru.bobby.bio.Profiles.DATAJPA;
import static ru.bobby.bio.Profiles.POSTGRES;

/**
 * Created by b.istomin on 01.02.2016.
 */
@ActiveProfiles({DATAJPA, POSTGRES})
public class DataJpaUserProceduresServiceTest extends UserProceduresServiceTest {
}
