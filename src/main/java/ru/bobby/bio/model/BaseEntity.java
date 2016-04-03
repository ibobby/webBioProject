package ru.bobby.bio.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * Created by bobby on 13.05.2015.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {

    protected final static Logger LOG = LoggerFactory.getLogger(BaseEntity.class);

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name="global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(int id) {
        this.id = id;
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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

    public void update(int id) {
        if (isNew()) {
            setId(id);
        } else if (id != getId()) {
            throw new IllegalStateException(this + " has id differed from " + id);
        }
    }
}
