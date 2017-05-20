package edu.core.java.races.loader;

import edu.core.java.races.domain.Races;
import edu.core.java.races.domain.ResultRace;
import edu.core.java.races.repository.RacesRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.RacesTranslator;
import edu.core.java.races.vo.RacesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubeto on 20.05.17.
 */
public class RacesLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(RacesLoader.class);

    private RacesRepository repository = null;
    private RacesTranslator translator = null;
    private HippodromeLoader hippodromeLoader = null;
    private ResultRaceLoader resultRaceLoader = null;

    public RacesLoader(RacesRepository racesRepository,
                       RacesTranslator racesTranslator,
                       HippodromeLoader hippodromeLoader,
                       ResultRaceLoader resultRaceLoader) {
        this.repository = racesRepository;
        this.translator = translator;
        this.hippodromeLoader = hippodromeLoader;
        this.resultRaceLoader = resultRaceLoader;
    }

    public Races getEntityById(Long id) {
        RacesVO racesVO = repository.getValueObject(id);
        Races races = null;

        if (racesVO != null) {
            races = translator.fromValueToDomain(racesVO);
            races.setHippodrome(hippodromeLoader.getEntityById(racesVO.getHippodromeId()));

            Long[] racesId = racesVO.getRaceResults();
            List<ResultRace> listRaces = new ArrayList<ResultRace>();

            for (int i = 0; i < racesVO.getRaceResults().length; i++) {
                listRaces.add(resultRaceLoader.getEntityById(racesId[i]));
            }
            ResultRace[] resultArray = new ResultRace[ listRaces.size() ];
            listRaces.toArray( resultArray );
            races.setRaceResults(resultArray);
        }

        return races;
    }

    public Repository getRepository() { return repository; }
}
