package ru.bobby.bio.model;

import org.hibernate.validator.constraints.NotEmpty;
import ru.bobby.bio.util.TimeUtil;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by bobby on 13.05.2015.
 */
@Entity
@Table(name = "procedures")
@NamedQueries({
        @NamedQuery(name = "UserProcedures.GET", query = "SELECT p FROM UserProcedures p WHERE p.id=:id AND p.user.id=:userId"),
        @NamedQuery(name = "UserProcedures.ALL_SORTED", query = "SELECT p FROM UserProcedures p WHERE p.user.id=:userId ORDER BY p.dateTime DESC"),
        @NamedQuery(name = "UserProcedures.DELETE_ALL", query = "DELETE FROM UserProcedures p WHERE p.user.id=:userId"),
        @NamedQuery(name = "UserProcedures.DELETE", query = "DELETE FROM UserProcedures p WHERE p.id=:id AND p.user.id=:userId"),
        @NamedQuery(name = "UserProcedures.GET_BETWEEN", query = "SELECT p FROM UserProcedures p WHERE p.user.id=:userId " +
                                                                  "AND p.dateTime>=:after AND p.dateTime<:before ORDER BY p.dateTime DESC")
})
public class UserProcedures extends BaseEntity {

    public static final String GET = "UserProcedures.GET";
    public static final String ALL_SORTED = "UserProcedures.ALL_SORTED";
    public static final String DELETE_ALL = "UserProcedures.DELETE_ALL";
    public static final String DELETE = "UserProcedures.DELETE";
    public static final String GET_BETWEEN = "UserProcedures.GET_BETWEEN";


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "datetime", nullable = false)
    protected LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    @NotEmpty
    protected String description;

    @Column(name = "scores")
    protected int scores;


    public UserProcedures(Integer id, LocalDateTime dateTime, String description, int scores) {
        super(id);
        //this.user = user;
        this.dateTime = dateTime;
        this.description = description;
        this.scores = scores;
    }

    public UserProcedures(UserProcedures proc) {
        this(proc.getId(), proc.getDateTime(), proc.getDescription(), proc.getScores());
    }

    public UserProcedures() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "UserProcedures{" +
                "user=" + id +
                ", dateTime=" + TimeUtil.toString(dateTime) +
                ", description='" + description + '\'' +
                ", scores=" + scores +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
