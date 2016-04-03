package ru.bobby.bio;

import ru.bobby.bio.model.BaseEntity;
import ru.bobby.bio.model.Role;

import java.util.Collections;
import java.util.Set;

/**
 * Created by b.istomin on 14.05.2015.
 */
public class LoggedUser {

    protected int id = BaseEntity.START_SEQ;
    protected Set<Role> roles = Collections.singleton(Role.ROLE_USER);
    protected boolean enabled = true;

    private static LoggedUser LOGGED_USER = new LoggedUser();

    public static LoggedUser get() {
        return LOGGED_USER;
    }

    public static int id() {
        return get().id;
    }

    public Set<Role> getAuthorities() {
        return roles;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
