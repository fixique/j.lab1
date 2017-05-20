package edu.core.java.races.domain;

import java.util.Date;

/**
 * Created by Ubeto on 20.05.17.
 */
public class Races extends DomainObject {

    private Date raceDate;
    private Hippodrome hippodrome;
    private ResultRace[] raceResults;

    public Races(Long id, Date date, Hippodrome hippodrome, ResultRace[] raceResults) {
        super(id);

        this.hippodrome = hippodrome;
        this.raceDate = date;
        this.raceResults = raceResults;
    }

    public Races(Long id, Date date) {
        super(id);

        this.hippodrome = null;
        this.raceDate = date;
        this.raceResults = null;
    }

    public Date getRaceDate() { return raceDate; }
    public Hippodrome getHippodrome() { return hippodrome; }
    public ResultRace[] getRaceResults() { return raceResults; }

    public void setHippodrome(Hippodrome hippodrome) { this.hippodrome = hippodrome; }
    public void setRaceResults(ResultRace[] raceResults) {this.raceResults = raceResults; }
}
