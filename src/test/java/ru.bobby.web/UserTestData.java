package ru.bobby.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bobby.web.matcher.ModelMatcher;
import ru.bobby.web.model.BaseEntity;
import ru.bobby.web.model.Role;
import ru.bobby.web.model.User;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by b.istomin on 09.07.2015.
 */
public class UserTestData {

    private static final Logger LOG = LoggerFactory.getLogger(UserTestData.class);

    public static final TestUser USER = new TestUser(BaseEntity.START_SEQ, "User", "user@yandex.ru", "password", true, EnumSet.of(Role.ROLE_USER));
    public static final User ADMIN = new TestUser(BaseEntity.START_SEQ + 1, "Admin", "admin@gmail.com", "admin", true, EnumSet.of(Role.ROLE_ADMIN));

    public static class TestUser extends User {

        public TestUser(User user) {
            this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getAuthorities());
        }

        public TestUser(String name, String email, String password, boolean enabled, Set<Role> authorities) {
            this(null, name, email, password, enabled, authorities);
        }

        public TestUser(Integer id, String name, String email, String password, boolean enabled, Set<Role> authorities) {
            super(id, name, email, password, enabled, authorities);
        }

        public User asUser() {
            return new User(this);
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestUser that = (TestUser) o;

            return Objects.equals(this.password, that.password)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.email, that.email)
                    && Objects.equals(this.enabled, that.enabled);

        }
    }

    public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(
            u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)));

}
