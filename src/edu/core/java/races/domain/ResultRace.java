package edu.core.java.races.domain;

import java.sql.Time;

/**
 * Created by Ubeto on 20.05.17.
 */
public class ResultRace extends DomainObject {

    private Jockey jockey;
    private Horse horse;
    private Integer place;
    private Time time;

    public ResultRace(Long id, Jockey jockey, Horse horse, Integer place, Time time) {
        super(id);

        this.jockey = jockey;
        this.horse = horse;
        this.place = place;
        this.time = time;
    }

    public ResultRace(Long id, Integer place, Time time) {
        super(id);

        this.place = place;
        this.time = time;
        this.horse = null;
        this.jockey = null;
    }


    public Jockey getJockey() { return jockey; }
    public Horse getHorse() { return horse; }
    public Integer getPlace() { return place; }
    public Time getTime() { return time; }

    public void setJockey(Jockey jockey) { this.jockey = jockey; }
    public void setHorse(Horse horse) { this.horse = horse; }
}
