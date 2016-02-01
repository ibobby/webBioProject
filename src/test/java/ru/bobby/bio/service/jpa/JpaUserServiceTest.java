package ru.bobby.bio.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import ru.bobby.bio.service.UserServiceTest;

import static ru.bobby.bio.Profiles.JPA;
import static ru.bobby.bio.Profiles.POSTGRES;

/**
 * Created by b.istomin on 01.02.2016.
 */
@ActiveProfiles({JPA, POSTGRES})
public class JpaUserServiceTest extends UserServiceTest {
}
