package edu.core.java.races.vo;

import java.util.Date;

/**
 * Created by Ubeto on 20.05.17.
 */

//like bd raceVO link to competition
public class CompetitionVO extends ValueObject {

    private Date raceData;
    private Long hippodromeId;
    //private Long[] raceResults;

    public CompetitionVO(Long id, Date raceData, Long hippodromeId) {
        super.id = id;
        this.raceData = raceData;
        this.hippodromeId = hippodromeId;
        //this.raceResults = raceResults;
    }

    public CompetitionVO(Date raceData, Long hippodromeId) {
        this.raceData = raceData;
        this.hippodromeId = hippodromeId;
        //this.raceResults = raceResults;
    }

    public CompetitionVO() {}

    public Date getRaceData() { return raceData; }
    public Long getHippodromeId() { return hippodromeId; }
    //public Long[] getRaceResults() { return raceResults; }

    public void setRaceData(Date date) {this.raceData = date;}
}
