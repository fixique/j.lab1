package edu.core.java.races.translator;

import edu.core.java.races.domain.Horse;
import edu.core.java.races.vo.HorseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class HorseTranslator implements Translator<HorseVO, Horse> {
    private static final Logger logger = LoggerFactory.getLogger(HorseTranslator.class);


    @Override
    public HorseVO fromDomainToValue(Horse horse) {
        HorseVO valueObject = null;

        if (horse != null) {
            valueObject = new HorseVO(horse.getNickname(), horse.getAge(), horse.getGender(), horse.getOwner().getId());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return valueObject;
    }

    @Override
    public Horse fromValueToDomain(HorseVO horseVO) {
        Horse horse = null;

        if (horseVO != null) {
            horse = new Horse(horseVO.getId(), horse.getNickname(), horse.getGender(), horse.getAge());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return horse;
    }
}
