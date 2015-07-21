package ru.bobby.web.model;

import ru.bobby.web.util.exception.TimeUtil;

import java.time.LocalDateTime;

/**
 * Created by bobby on 13.05.2015.
 */
public class UserProcedures extends BaseEntity {

    private User user;
    protected LocalDateTime dateTime;
    protected String description;
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
                "user=" + user +
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
