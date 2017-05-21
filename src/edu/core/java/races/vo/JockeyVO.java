package edu.core.java.races.vo;

/**
 * Created by Ubeto on 20.05.17.
 */
public class JockeyVO extends ValueObject {

    private String fullName;
    private Integer age;
    private double rating;

    public JockeyVO(Long id, String fullName, Integer age, double rating) {
        super.id = id;
        this.fullName = fullName;
        this.age = age;
        this.rating = rating;
    }

    public JockeyVO(String fullName, Integer age, double rating) {
        this.fullName = fullName;
        this.age = age;
        this.rating = rating;
    }

    public JockeyVO() {}

    public String getFullName() { return fullName; }
    public Integer getAge() { return age; }
    public double getRating() { return rating; }
}
