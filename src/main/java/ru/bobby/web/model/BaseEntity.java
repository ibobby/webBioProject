package ru.bobby.web.model;

/**
 * Created by bobby on 13.05.2015.
 */
public class BaseEntity {

    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

}
