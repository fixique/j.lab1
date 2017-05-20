package edu.core.java.races.loader;

import edu.core.java.races.domain.DomainObject;
import edu.core.java.races.repository.Repository;
import edu.core.java.races.vo.ValueObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ubeto on 20.05.17.
 */
public abstract class Loader <D extends DomainObject> {

    public abstract Repository getRepository();
    public abstract D getEntityById(Long id);

    public List<D> getAllEntities() {
        Map<Long, ValueObject> entities = getRepository().getAllValueObjects();
        List<D> clients = new LinkedList<>();
        for (ValueObject vo: entities.values()) clients.add(getEntityById(vo.getId()));

        return clients;
    }
}
