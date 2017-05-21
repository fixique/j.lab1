package edu.core.java.races.loader;

import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.repository.ResultRaceRepository;
import edu.core.java.races.translator.ResultRaceTranslator;
import edu.core.java.races.vo.ResultRaceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class ResultRaceLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(ResultRaceLoader.class);

    private ResultRaceRepository repository = null;
    private ResultRaceTranslator translator = null;
    private JockeyLoader jockeyLoader = null;
    private HorseLoader horseLoader = null;

    public ResultRaceLoader(ResultRaceRepository resultRaceRepository,
                            ResultRaceTranslator resultRaceTranslator,
                            JockeyLoader jockeyLoader,
                            HorseLoader horseLoader) {
        this.repository = resultRaceRepository;
        this.translator = resultRaceTranslator;
        this.jockeyLoader = jockeyLoader;
        this.horseLoader = horseLoader;
    }

    public ResultRace getEntityById(Long id) {
        ResultRaceVO resultRaceVO = repository.getValueObject(id);
        ResultRace resultRace = null;

        if (resultRaceVO != null) {
            resultRace = translator.fromValueToDomain(resultRaceVO);
            resultRace.setJockey(jockeyLoader.getEntityById(resultRaceVO.getJockeyId()));
            resultRace.setHorse(horseLoader.getEntityById(resultRaceVO.getHorseId()));
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return resultRace;
    }

    public Repository getRepository() { return repository; }
}
