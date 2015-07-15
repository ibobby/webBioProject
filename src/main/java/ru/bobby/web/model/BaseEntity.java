package ru.bobby.web.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bobby on 13.05.2015.
 */
public class BaseEntity {

    protected final static Logger LOG = LoggerFactory.getLogger(BaseEntity.class);

    public static final int START_SEQ = 1000000;

    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o.getClass() == getClass())) return false;

        BaseEntity that = (BaseEntity) o;
        if (id == null || that.id == null) {
            throw new IllegalStateException("Equals '" + this + "' and '" + that + "' with null id");
        }

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }
}
