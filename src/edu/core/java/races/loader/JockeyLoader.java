package edu.core.java.races.loader;

import edu.core.java.races.domain.Jockey;
import edu.core.java.races.repository.JockeyRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.JockeyTranslator;
import edu.core.java.races.vo.JockeyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class JockeyLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(JockeyLoader.class);

    private JockeyRepository repository = null;
    private JockeyTranslator translator = null;

    public JockeyLoader(JockeyRepository jockeyRepository, JockeyTranslator jockeyTranslator) {
        this.repository = jockeyRepository;
        this.translator = jockeyTranslator;
    }

    public Jockey getEntityById(Long id) {
        JockeyVO jockeyVO = repository.getValueObject(id);
        Jockey jockey = null;

        if (jockeyVO != null) {
            jockey = translator.fromValueToDomain(jockeyVO);
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return jockey;
    }

    public Repository getRepository() { return repository; }
}
