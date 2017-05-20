package edu.core.java.races.domain;

/**
 * Created by Ubeto on 20.05.17.
 */
public abstract class DomainObject {

    protected Long id;

    public DomainObject(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
