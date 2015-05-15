package ru.bobby.web;

import ru.bobby.web.model.Role;

import java.util.Set;

/**
 * Created by b.istomin on 14.05.2015.
 */
public class LoggedUser {

    protected int id;
    protected Set<Role> roles;
    protected boolean enabled;

    public int getId() {
        return id;
    }
}
