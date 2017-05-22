package edu.core.java.races.domain;

import edu.core.java.races.additional.Gender;

/**
 * Created by Ubeto on 20.05.17.
 */

//todo age to birth
public class Horse extends DomainObject {

    private String nickname;
    private Gender gender;
    private Integer age;
    private Owner owner;

    public Horse(Long id, String nickname, Gender gender, Integer age, Owner owner) {
        super(id);

        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.owner = owner;
    }

    public Horse(Long id, String nickname, Gender gender, Integer age) {
        super(id);

        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.owner = null;
    }
    public String getNickname() { return nickname; }
    public Gender getGender() { return gender; }
    public Integer getAge() { return age; }
    public Owner getOwner() { return owner; }

    public void setOwner(Owner owner) { this.owner = owner; }
}
