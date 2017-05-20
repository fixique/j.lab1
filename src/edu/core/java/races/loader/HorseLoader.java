package edu.core.java.races.loader;

import edu.core.java.races.domain.Horse;
import edu.core.java.races.domain.Owner;
import edu.core.java.races.repository.HorseRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.HorseTranslator;
import edu.core.java.races.vo.HorseVO;
import edu.core.java.races.vo.OwnerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HorseLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(HorseLoader.class);

    private HorseRepository repository = null;
    private HorseTranslator translator = null;
    private OwnerLoader ownerLoader = null;

    public HorseLoader(HorseRepository horseRepository, HorseTranslator horseTranslator, OwnerLoader ownerLoader) {
        this.repository = horseRepository;
        this.translator = horseTranslator;
        this.ownerLoader = ownerLoader;
    }

    public Horse getEntityById(Long id) {
        HorseVO horseVO = repository.getValueObject(id);
        Horse horse = null;

        if (horseVO != null) {
            horse = translator.fromValueToDomain(horseVO);
            horse.setOwner(ownerLoader.getEntityById(horseVO.getOwnerId()));
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return horse;
    }

    public Repository getRepository() { return repository; }
}
