package edu.core.java.races.domain;

/**
 * Created by Ubeto on 20.05.17.
 */
public class Owner extends DomainObject {

    private String fullName;
    private String address;


    public Owner(Long id, String fullName, String address) {
        super(id);
        this.fullName = fullName;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
}
