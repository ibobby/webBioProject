package ru.bobby.web.model;

import java.time.LocalDateTime;

/**
 * Created by bobby on 13.05.2015.
 */
public class UserProcedures extends BaseEntity {

    private User user;
    protected LocalDateTime dateTime;
    protected String description;
    protected int scores;

    public UserProcedures(int id, User user, LocalDateTime dateTime, String description, int scores) {
        super(id);
        this.user = user;
        this.dateTime = dateTime;
        this.description = description;
        this.scores = scores;
    }
}
