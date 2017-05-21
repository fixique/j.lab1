package edu.core.java.races.vo;

import java.util.Date;

/**
 * Created by Ubeto on 20.05.17.
 */
public class RacesVO extends ValueObject {

    private Date raceData;
    private Long hippodromeId;
    private Long[] raceResults;

    public RacesVO(Long id, Date raceData, Long hippodromeId, Long[] raceResults) {
        super.id = id;
        this.raceData = raceData;
        this.hippodromeId = hippodromeId;
        this.raceResults = raceResults;
    }

    public RacesVO(Date raceData, Long hippodromeId, Long[] raceResults) {
        this.raceData = raceData;
        this.hippodromeId = hippodromeId;
        this.raceResults = raceResults;
    }

    public RacesVO() {}

    public Date getRaceData() { return raceData; }
    public Long getHippodromeId() { return hippodromeId; }
    public Long[] getRaceResults() { return raceResults; }
}
