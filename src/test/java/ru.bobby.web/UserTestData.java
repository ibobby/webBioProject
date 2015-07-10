package ru.bobby.web;

import ru.bobby.web.model.Role;
import ru.bobby.web.model.User;

import java.util.Objects;
import java.util.Set;

/**
 * Created by b.istomin on 09.07.2015.
 */
public class UserTestData {

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

            return Objects.equals()

        }
    }

}
