package edu.core.java.races.vo;

/**
 * Created by Ubeto on 20.05.17.
 */
public class OwnerVO extends ValueObject {
    private String fullName;
    private String address;

    public OwnerVO(Long id, String fullName, String address) {
        super.id = id;
        this.fullName = fullName;
        this.address = address;
    }

    public OwnerVO(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    public OwnerVO() {}

    public String getFullName() { return fullName; }
    public String getAddress() { return address; }

}
