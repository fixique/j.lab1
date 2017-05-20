package edu.core.java.races.vo;

import java.sql.Time;

/**
 * Created by Ubeto on 20.05.17.
 */
public class ResultRaceVO extends ValueObject{

    private Long jockeyId;
    private Long horseId;
    private Integer place;
    private Time time;

    public ResultRaceVO(Long id, Long jockeyId, Long horseId, Integer place, Time time) {
        super.id = id;
        this.jockeyId = jockeyId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public ResultRaceVO(Long jockeyId, Long horseId, Integer place, Time time) {
        this.jockeyId = jockeyId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public Long getJockey() { return jockeyId; }
    public Long getHorse() { return horseId; }
    public Integer getPlace() { return place; }
    public Time getTime() { return time; }
}
