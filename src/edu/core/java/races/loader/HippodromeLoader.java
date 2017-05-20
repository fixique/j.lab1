package edu.core.java.races.loader;

import edu.core.java.races.domain.Hippodrome;
import edu.core.java.races.repository.HippodromeRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.HippodromeTranslator;
import edu.core.java.races.vo.HippodromeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HippodromeLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(HippodromeLoader.class);

    private HippodromeRepository repository = null;
    private HippodromeTranslator translator = null;

    public HippodromeLoader(HippodromeRepository hippodromeRepository, HippodromeTranslator hippodromeTranslator) {
        this.repository = hippodromeRepository;
        this.translator = hippodromeTranslator;
    }

    public Hippodrome getEntityById(Long id) {
        HippodromeVO hippodromeVO = repository.getValueObject(id);
        Hippodrome hippodrome = null;

        if (hippodromeVO != null) {
            hippodrome = translator.fromValueToDomain(hippodromeVO);
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return hippodrome;
    }

    public Repository getRepository() { return repository; }
}
