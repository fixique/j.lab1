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

    public ResultRaceVO(Integer place, Time time, Long id, Long horseId, Long jockeyId) {
        super.id = id;
        this.jockeyId = jockeyId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public ResultRaceVO(Integer place, Time time, Long jockeyId, Long horseId) {
        this.jockeyId = jockeyId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public ResultRaceVO() {}

    public Long getJockeyId() { return jockeyId; }
    public Long getHorseId() { return horseId; }
    public Integer getPlace() { return place; }
    public Time getTime() { return time; }
}
