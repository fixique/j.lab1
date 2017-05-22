package edu.core.java.races.translator;

import edu.core.java.races.domain.Competition;
import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.vo.CompetitionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubeto on 20.05.17.
 */
public class CompetitionTranslator implements Translator<CompetitionVO, Competition> {
    private static final Logger logger = LoggerFactory.getLogger(CompetitionTranslator.class);


    @Override
    public CompetitionVO fromDomainToValue(Competition competition) {
        CompetitionVO competitionVO = null;
        //List<Long> list = new ArrayList<Long>();

        if (competition != null) {
//            ResultRace[] racesArray = competition.getRaceResults();
//            for (int i = 0; i < competition.getRaceResults().length; i++) {
//                list.add(racesArray[i].getId());
//            }
//
//            Long[] racesResult = new Long[ list.size() ];
//            list.toArray( racesResult );

            competitionVO = new CompetitionVO(competition.getRaceDate(), competition.getHippodrome().getId());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return competitionVO;
    }

    @Override
    public Competition fromValueToDomain(CompetitionVO competitionVO) {
        Competition competition = null;

        if (competitionVO != null) {
            competition = new Competition(competitionVO.getId(), competitionVO.getRaceData());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return competition;
    }
}
