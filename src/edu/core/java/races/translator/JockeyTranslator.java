package edu.core.java.races.translator;

import edu.core.java.races.domain.Jockey;
import edu.core.java.races.vo.JockeyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ubeto on 20.05.17.
 */
public class JockeyTranslator implements Translator<JockeyVO, Jockey> {
    private static final Logger logger = LoggerFactory.getLogger(JockeyTranslator.class);


    @Override
    public JockeyVO fromDomainToValue(Jockey jockey) {
        JockeyVO valueObject = null;

        if (jockey != null) {
            valueObject = new JockeyVO(jockey.getFullName(), jockey.getAge(), jockey.getRating());
            logger.info("Object was converted from Domain to Value");
        } else {
            logger.error("Object == null, object wasn't converted");
        }

        return valueObject;
    }

    @Override
    public Jockey fromValueToDomain(JockeyVO jockeyVO) {
        Jockey jockey = null;

        if (jockeyVO != null) {
            jockey = new Jockey(jockeyVO.getId(), jockeyVO.getFullName(), jockeyVO.getAge(), jockeyVO.getRating());
            logger.info("Object was converted from Value to Domain");
        } else {
            logger.error("Object == nul, object wasn't converted");
        }

        return jockey;
    }
}
