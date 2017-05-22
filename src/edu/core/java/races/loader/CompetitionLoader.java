package edu.core.java.races.loader;

import edu.core.java.races.domain.Competition;
import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.repository.CompetitionRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.CompetitionTranslator;
import edu.core.java.races.vo.CompetitionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubeto on 20.05.17.
 */
public class CompetitionLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(CompetitionLoader.class);

    private CompetitionRepository repository = null;
    private CompetitionTranslator translator = null;
    private HippodromeLoader hippodromeLoader = null;


    public CompetitionLoader(CompetitionRepository competitionRepository,
                             CompetitionTranslator competitionTranslator,
                             HippodromeLoader hippodromeLoader) {
        this.repository = competitionRepository;
        this.translator = competitionTranslator;
        this.hippodromeLoader = hippodromeLoader;
    }

    public Competition getEntityById(Long id) {
        CompetitionVO competitionVO = repository.getValueObject(id);
        Competition competition = null;

        if (competitionVO != null) {
            competition = translator.fromValueToDomain(competitionVO);
            competition.setHippodrome(hippodromeLoader.getEntityById(competitionVO.getHippodromeId()));
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return competition;
    }

    public Repository getRepository() { return repository; }
}
