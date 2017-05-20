package edu.core.java.races.vo;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HippodromeVO extends ValueObject {

    private String name;
    private String address;

    public HippodromeVO(Long id, String name, String address) {
        super.id = id;
        this.name = name;
        this.address = address;
    }

    public HippodromeVO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}
