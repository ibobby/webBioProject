package ru.bobby.bio.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by bobby on 13.05.2015.
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
@NamedQueries({
        @NamedQuery(name = "User.DELETE", query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = "User.BY_EMAIL", query = "SELECT u FROM User u LEFT JOIN FETCH u.authorities WHERE u.email=?1"),
        @NamedQuery(name = "User.ALL_SORTED", query = "SELECT u FROM User u LEFT JOIN FETCH u.authorities ORDER BY u.name, u.email")
})
public class User extends NamedEntity {

    public static final String DELETE = "User.DELETE";
    public static final String BY_EMAIL = "User.BY_EMAIL";
    public static final String ALL_SORTED = "User.ALL_SORTED";

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    protected String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 5)
    protected String password;

    @Column(name = "enabled", nullable = false)
    protected boolean enabled;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    protected Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Role> authorities;

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
