package edu.core.java.races.translator;

import edu.core.java.races.domain.DomainObject;
import edu.core.java.races.vo.ValueObject;

/**
 * Created by Ubeto on 20.05.17.
 */
public interface Translator<V extends ValueObject, D extends DomainObject> {
    V fromDomainToValue(D d);
    D fromValueToDomain(V v);
}
