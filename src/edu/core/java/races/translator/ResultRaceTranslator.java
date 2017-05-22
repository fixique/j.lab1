package edu.core.java.races.translator;

import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.vo.ResultRaceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class ResultRaceTranslator implements Translator<ResultRaceVO, ResultRace> {
    private static final Logger logger = LoggerFactory.getLogger(ResultRaceTranslator.class);


    @Override
    public ResultRaceVO fromDomainToValue(ResultRace resultRace) {
        ResultRaceVO valueObject = null;

        if (resultRace != null) {
            valueObject = new ResultRaceVO(resultRace.getPlace(), resultRace.getTime(), resultRace.getJockey().getId(), resultRace.getHorse().getId(), resultRace.getCompetition().getId());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return valueObject;
    }

    @Override
    public ResultRace fromValueToDomain(ResultRaceVO resultRaceVO) {
        ResultRace race = null;

        if (resultRaceVO != null) {
            race = new ResultRace(resultRaceVO.getId(), resultRaceVO.getPlace(), resultRaceVO.getTime());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return race;
    }
}
