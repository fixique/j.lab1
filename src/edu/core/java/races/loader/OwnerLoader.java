package edu.core.java.races.loader;

import edu.core.java.races.domain.Owner;
import edu.core.java.races.repository.OwnerRepository;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.translator.OwnerTranslator;
import edu.core.java.races.vo.OwnerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class OwnerLoader extends Loader {
    private static final Logger logger = LoggerFactory.getLogger(OwnerLoader.class);

    private OwnerRepository repository = null;
    private OwnerTranslator translator = null;

    public OwnerLoader(OwnerRepository ownerRepository, OwnerTranslator ownerTranslator) {
        this.repository = ownerRepository;
        this.translator = ownerTranslator;
    }

    public Owner getEntityById(Long id) {
        OwnerVO ownerVO = repository.getValueObject(id);
        Owner owner = null;

        if (ownerVO != null) {
            owner = translator.fromValueToDomain(ownerVO);
            logger.info("Domain object was successfully loaded");
        } else {
            logger.error("Domain object wasn't loaded");
        }

        return owner;
    }

    public Repository getRepository() { return repository; }
}
