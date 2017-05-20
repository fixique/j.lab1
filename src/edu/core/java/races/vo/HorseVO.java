package edu.core.java.races.vo;

import edu.core.java.races.additional.Gender;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HorseVO extends ValueObject{

    private Long ownerId;
    private String nickname;
    private Gender gender;
    private Integer age;

    public HorseVO(Long id, String nickname, Integer age, Gender gender, Long ownerId) {
        super.id = id;
        this.ownerId = ownerId;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
    }

    public HorseVO(String nickname, Integer age, Gender gender, Long ownerId) {
        this.ownerId = ownerId;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
    }

    public Long getOwnerId() { return ownerId; }
    public String getNickname() { return nickname; }
    public Gender getGender() { return gender; }
    public Integer getAge() { return age; }
}
