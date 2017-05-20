package edu.core.java.races.repository;

import edu.core.java.races.vo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ubeto on 20.05.17.
 */
public abstract class Repository<V extends ValueObject> {
    protected Map<Long, V> valueObjects = new LinkedHashMap<Long, V>();
    private static final Logger logger = LoggerFactory.getLogger(Repository.class);

    public void add(V v) {
        if (v != null) {
            valueObjects.put(v.getId(), v);
            logger.info("Object successfully added");
        } else {
            logger.error("Object wasn't added");
        }
    }

    public V getValueObject(Long id) {
        V result = valueObjects.get(id);

        if (result != null) {
            logger.info("Object with id: " + id + " was found");
        } else {
            logger.error("Object with id: " + id + " wasn't found");
        }

        return result;
    }

    public void updateValueObject(V v) {
        if (v != null && valueObjects.containsKey(v.getId())) {
            valueObjects.put(v.getId(), v);
            logger.info("Object with id: " + v.getId() + " was successfully updated");
        } else {
            logger.error("Object with id: " + v.getId() + " doesn't exist");
        }
    }

    public void deleteValueObject(Long id) {
        if (valueObjects.remove(id) != null) {
            logger.info("Object with id: " + id + " was successfully deleted");
        } else {
            logger.error("Object with id: " + id + " hasn't been deleted");
        }
    }

    public Map<Long, V> getAllValueObjects() { return valueObjects; }
    public boolean contain(Long id) { return valueObjects.containsKey(id); }
}
