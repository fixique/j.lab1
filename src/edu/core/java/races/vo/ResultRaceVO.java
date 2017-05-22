package edu.core.java.races.vo;

import java.sql.Time;

/**
 * Created by Ubeto on 20.05.17.
 */
public class ResultRaceVO extends ValueObject{

    private Long jockeyId;
    private Long horseId;
    private Long competitionId;
    private Integer place;
    private Long time;

    public ResultRaceVO(Integer place, Long time, Long id, Long horseId, Long jockeyId, Long competitionId) {
        super.id = id;
        this.jockeyId = jockeyId;
        this.competitionId = competitionId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public ResultRaceVO(Integer place, Long time, Long jockeyId, Long horseId, Long competitionId) {
        this.jockeyId = jockeyId;
        this.competitionId = competitionId;
        this.horseId = horseId;
        this.place = place;
        this.time = time;
    }

    public ResultRaceVO() {}

    public Long getJockeyId() { return jockeyId; }
    public Long getHorseId() { return horseId; }
    public Long getCompetitionId() { return competitionId; }
    public Integer getPlace() { return place; }
    public Long getTime() { return time; }
}
