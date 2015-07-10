package ru.bobby.web.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by bobby on 13.05.2015.
 */
public class User extends NamedEntity {

    private String email;

    private String password;

    private boolean enabled;

    private Date registered = new Date();

    private Set<Role> authorities;

    public User() {

    }

    public User(Integer id, String name, String email, String password, boolean enabled, Set<Role> authorities) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public User(User u) {
        this(u.getId(), u. getName(), u.getEmail(), u.getPassword(), u.isEnabled(), u.getAuthorities());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void addAuthority(Role authority) {
        if (authorities == null) {
            authorities = EnumSet.of(authority);
        } else {
            authorities.add(authority);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                "}";
    }
}
