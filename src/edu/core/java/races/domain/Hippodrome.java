package edu.core.java.races.domain;

/**
 * Created by Ubeto on 20.05.17.
 */
public class Hippodrome extends DomainObject {

    private String name;
    private String address;

    public Hippodrome(Long id, String name, String address) {
        super(id);

        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}
