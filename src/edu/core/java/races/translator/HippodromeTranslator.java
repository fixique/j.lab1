package edu.core.java.races.translator;

import edu.core.java.races.domain.Hippodrome;
import edu.core.java.races.vo.HippodromeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HippodromeTranslator implements Translator<HippodromeVO, Hippodrome> {
    private static final Logger logger = LoggerFactory.getLogger(HorseTranslator.class);

    @Override
    public HippodromeVO fromDomainToValue(Hippodrome hippodrome) {
        HippodromeVO valueObject = null;

        if (hippodrome != null) {
            valueObject = new HippodromeVO(hippodrome.getName(), hippodrome.getAddress());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return valueObject;
    }

    @Override
    public Hippodrome fromValueToDomain(HippodromeVO hippodromeVO) {
        Hippodrome hippodrome = null;

        if (hippodromeVO != null) {
            hippodrome = new Hippodrome(hippodrome.getId() ,hippodrome.getName(),hippodrome.getAddress());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return hippodrome;
    }
}
