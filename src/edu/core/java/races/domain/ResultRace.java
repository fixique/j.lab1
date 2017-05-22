package edu.core.java.races.domain;

import java.sql.Time;

/**
 * Created by Ubeto on 20.05.17.
 */

//time
public class ResultRace extends DomainObject {

    private Jockey jockey;
    private Horse horse;
    private Competition competition;
    private Integer place;
    private Long time;

    public ResultRace(Long id, Jockey jockey, Horse horse, Integer place, Long time, Competition competition) {
        super(id);
        this.competition = competition;
        this.jockey = jockey;
        this.horse = horse;
        this.place = place;
        this.time = time;
    }

    public ResultRace(Long id, Integer place, Long time) {
        super(id);

        this.place = place;
        this.time = time;
        this.horse = null;
        this.jockey = null;
        this.competition = null;
    }


    public Jockey getJockey() { return jockey; }
    public Horse getHorse() { return horse; }
    public Integer getPlace() { return place; }
    public Long getTime() { return time; }
    public Competition getCompetition() { return competition;}

    public void setJockey(Jockey jockey) { this.jockey = jockey; }
    public void setHorse(Horse horse) { this.horse = horse; }
    public void setCompetition(Competition competition) { this.competition = competition; }
}
