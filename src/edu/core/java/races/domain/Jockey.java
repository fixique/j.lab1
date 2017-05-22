package edu.core.java.races.domain;

/**
 * Created by Ubeto on 20.05.17.
 */

//age
public class Jockey extends DomainObject {

    private String fullName;
    private Integer age;
    private double rating;

    public Jockey(Long id, String fullName, Integer age, double rating) {
        super(id);

        this.fullName = fullName;
        this.age = age;
        this.rating = rating;
    }

    public String getFullName() { return fullName; }
    public Integer getAge() { return age; }
    public double getRating() { return rating; }
}
