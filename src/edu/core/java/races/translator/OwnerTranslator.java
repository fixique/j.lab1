package edu.core.java.races.translator;

import edu.core.java.races.domain.Owner;
import edu.core.java.races.vo.OwnerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class OwnerTranslator implements Translator<OwnerVO, Owner> {
    private static final Logger logger = LoggerFactory.getLogger(OwnerTranslator.class);

    @Override
    public OwnerVO fromDomainToValue(Owner owner) {
        OwnerVO ownerValue = null;

        if (owner != null) {
            ownerValue = new OwnerVO(owner.getFullName(), owner.getAddress());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return ownerValue;
    }

    @Override
    public Owner fromValueToDomain(OwnerVO ownerVO) {
        Owner owner = null;

        if (ownerVO != null) {
            owner = new Owner(ownerVO.getId(), ownerVO.getFullName(), ownerVO.getAddress());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }
        return owner;
    }
}
