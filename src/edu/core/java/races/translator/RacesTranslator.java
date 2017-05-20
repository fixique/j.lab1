package edu.core.java.races.translator;

import edu.core.java.races.domain.Races;
import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.vo.RacesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubeto on 20.05.17.
 */
public class RacesTranslator implements Translator<RacesVO, Races> {
    private static final Logger logger = LoggerFactory.getLogger(RacesTranslator.class);


    @Override
    public RacesVO fromDomainToValue(Races races) {
        RacesVO racesVO = null;
        List<Long> list = new ArrayList<Long>();

        if (races != null) {
            ResultRace[] racesArray = races.getRaceResults();
            for (int i = 0; i < races.getRaceResults().length; i++) {
                list.add(racesArray[i].getId());
            }

            Long[] racesResult = new Long[ list.size() ];
            list.toArray( racesResult );

            racesVO = new RacesVO(races.getRaceDate(), races.getHippodrome().getId(), racesResult);
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return racesVO;
    }

    @Override
    public Races fromValueToDomain(RacesVO racesVO) {
        Races races = null;

        if (racesVO != null) {
            races = new Races(racesVO.getId(), racesVO.getRaceData());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return races;
    }
}
