package edu.core.java.races;

import edu.core.java.races.additional.DataService;
import edu.core.java.races.additional.IncrementId;
import edu.core.java.races.loader.*;
import edu.core.java.races.domain.*;
import edu.core.java.races.repository.*;
import edu.core.java.races.vo.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Ubeto on 21.05.17.
 */
public class Races {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static IncrementId ownerId = new IncrementId();
    private static IncrementId horseId = new IncrementId();
    private static IncrementId jockeyId = new IncrementId();
    private static IncrementId hippodromeId = new IncrementId();
    private static IncrementId resultRaceId = new IncrementId();
    private static IncrementId raceId = new IncrementId();

    private static ObjectMapper mapper = new ObjectMapper();

    public static void start() {
        logger.info("Application has started");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("______________________________________");
            System.out.println("1. Add or Update entity");
            System.out.println("2. Delete entity");
            System.out.println("3. Show entity by id");
            System.out.println("4. Show all entities");
            System.out.println("5. Exit app");
            System.out.println("--------------------------------------");
            int choice;

            try {
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        addEntity();
                        break;
                    case 2:
                        deleteEntityById();
                        break;
                    case 3:
                        showEntityById();
                        break;
                    case 4:
                        showAllEntities();
                        break;
                    case 5:
                        logger.info("Application has stopped");
                        return;
                    default:
                        logger.warn("Incorrect choice");
                }

            } catch (NumberFormatException | ParseException | IOException ex) {
                logger.error(ex.getMessage());
            }
        }
    }

    private static void addEntity() throws IOException {
        logger.info("Start add entity");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter type of entity: ");
        System.out.println("______________________________________");
        System.out.println("1. Horse Owner");
        System.out.println("2. Horse");
        System.out.println("3. Jockey");
        System.out.println("4. Hippodrome");
        System.out.println("5. Race Results");
        System.out.println("6. Race");
        System.out.println("7. Back");
        System.out.println("______________________________________");
        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1:
                OwnerVO ownerVO = (OwnerVO) getVO(choice);
                if (ownerVO != null) {
                    setVO(getRepository(choice), ownerVO, ownerId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 2:
                HorseVO horseVO = (HorseVO) getVO(choice);
                if (horseVO != null && checkObjectExists(1, horseVO.getOwnerId())) {
                    setVO(getRepository(choice), horseVO, horseId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 3:
                JockeyVO jockeyVO = (JockeyVO) getVO(choice);
                if (jockeyVO != null) {
                    setVO(getRepository(choice), jockeyVO, jockeyId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 4:
                HippodromeVO hippodromeVO = (HippodromeVO) getVO(choice);
                if (hippodromeVO != null) {
                    setVO(getRepository(choice), hippodromeVO, hippodromeId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 5:
                ResultRaceVO resultRaceVO = (ResultRaceVO) getVO(choice);
                if (resultRaceVO != null && checkObjectExists(3, resultRaceVO.getJockeyId()) && checkObjectExists(2, resultRaceVO.getHorseId())) {
                    setVO(getRepository(choice), resultRaceVO, resultRaceId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 6:
                RacesVO racesVO = (RacesVO) getVO(choice);
                if (racesVO != null && checkObjectExists(4, racesVO.getHippodromeId())) {
                    //Long[] myObjects = mapper.readValue(, Long[].class);
                    setVO(getRepository(choice), racesVO, raceId);
                } else {
                    logger.error("Error adding");
                }
                break;
            case 7:
                logger.info("Stop add entity and back to main menu");
                return;
            default:
                logger.warn("Incorrect choice");
                break;
        }
    }

    private static void deleteEntityById() throws IOException, ParseException, NumberFormatException {
        logger.info("Start delete entity by id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose type of entity: ");
        System.out.println("______________________________________");
        System.out.println("1. Horse Owner");
        System.out.println("2. Horse");
        System.out.println("3. Jockey");
        System.out.println("4. Hippodrome");
        System.out.println("5. Race Results");
        System.out.println("6. Race");
        System.out.println("7. Back");
        System.out.println("______________________________________");
        int choice = Integer.parseInt(reader.readLine());

        Repository repository = getRepository(choice);

        if (repository != null) {
            System.out.println("Type entity id: ");
            Long id = Long.parseLong(reader.readLine());
            if (repository.contain(id)) {
                repository.deleteValueObject(id);
            } else {
                logger.error("Can't fine entity with id: " + id);
            }
        } else {
            logger.error("Incorrect choice");
        }
    }

    private static void showEntityById() throws IOException, ParseException, NumberFormatException {
        logger.info("Start show entity by id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose type of entity: ");
        System.out.println("______________________________________");
        System.out.println("1. Horse Owner");
        System.out.println("2. Horse");
        System.out.println("3. Jockey");
        System.out.println("4. Hippodrome");
        System.out.println("5. Race Results");
        System.out.println("6. Race");
        System.out.println("7. Back");
        System.out.println("______________________________________");
        int choice = Integer.parseInt(reader.readLine());
        System.out.println("Type entity id: ");
        Long id = Long.parseLong(reader.readLine());
        Loader loader = getLoader(choice);

        if (loader != null) {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loader.getEntityById(id)));
        } else {
            logger.error("Can't finde entity with id: " + id);
        }
    }

    private static void showAllEntities() throws IOException, ParseException, NumberFormatException {
        logger.info("Start show entity");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose type of entity: ");
        System.out.println("______________________________________");
        System.out.println("1. Horse Owner");
        System.out.println("2. Horse");
        System.out.println("3. Jockey");
        System.out.println("4. Hippodrome");
        System.out.println("5. Race Results");
        System.out.println("6. Race");
        System.out.println("7. Back");
        System.out.println("______________________________________");
        int choice = Integer.parseInt(reader.readLine());

        Loader loader = getLoader(choice);

        if (loader != null) {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loader.getAllEntities()));
        } else {
            logger.error("Empty entity");
        }
    }

    private static boolean checkObjectExists(Integer choice, Long id) {
        boolean flag = true;

        switch(choice) {
            case 1:
                OwnerRepository ownerRepository = (OwnerRepository) getRepository(choice);
                if (!ownerRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with owner data wasn't found");
                }
                break;
            case 2:
                HorseRepository horseRepository = (HorseRepository) getRepository(choice);
                if (!horseRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with horse data wasn't found");
                }
                break;
            case 3:
                JockeyRepository jockeyRepository = (JockeyRepository) getRepository(choice);
                if (!jockeyRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with jockey data wasn't found");
                }
                break;
            case 4:
                HippodromeRepository hippodromeRepository = (HippodromeRepository) getRepository(choice);
                if (!hippodromeRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with hippodrome data wasn't found");
                }
                break;
            case 5:
                ResultRaceRepository resultRaceRepository = (ResultRaceRepository) getRepository(choice);
                if (!resultRaceRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with result race data wasn't found");
                }
                break;
            case 6:
                RacesRepository racesRepository = (RacesRepository) getRepository(choice);
                if (!racesRepository.contain(id)) {
                    flag = false;
                    logger.error("Object with race data wasn't found");
                }
                break;
            default:
                flag = false;
                logger.error("Incorrect choice");
                break;
        }

        return flag;
    }

    private static ValueObject getVO(Integer choice) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file path to add entity: ");
        String filePath = reader.readLine();

        switch (choice) {
            case 1:
                return mapper.readValue(new FileInputStream(filePath), OwnerVO.class);
            case 2:
                return mapper.readValue(new FileInputStream(filePath), HorseVO.class);
            case 3:
                return mapper.readValue(new FileInputStream(filePath), JockeyVO.class);
            case 4:
                return mapper.readValue(new FileInputStream(filePath), HippodromeVO.class);
            case 5:
                return mapper.readValue(new FileInputStream(filePath), ResultRaceVO.class);
            case 6:
                return mapper.readValue(new FileInputStream(filePath), RacesVO.class);

        }

        return null;
    }

    private static void setVO(Repository repository, ValueObject valueObject, IncrementId id) {

        if (valueObject != null) {
            if (valueObject.getId() == null) {
                valueObject.setId(id.value);
                repository.add(valueObject);
                id.increment();
                logger.info("Value object was added");
            } else {
                repository.updateValueObject(valueObject);
                logger.info("Value object was updated");
            }
        } else {
            logger.error("Can't set. Value object is null");
        }
    }

    private static Repository getRepository(Integer choice) {
        Repository repository = null;

        switch (choice) {
            case 1:
                repository = DataService.getInstance().getOwnerRepository();
                break;
            case 2:
                repository = DataService.getInstance().getHorseRepository();
                break;
            case 3:
                repository = DataService.getInstance().getJockeyRepository();
                break;
            case 4:
                repository = DataService.getInstance().getHippodromeRepository();
                break;
            case 5:
                repository = DataService.getInstance().getResultRaceRepository();
                break;
            case 6:
                repository = DataService.getInstance().getRacesRepository();
                break;
            case 7:
                repository = null;
                logger.info("Back to menu");
                break;
            default:
                logger.error("Wrong choice");
                break;
        }

        return repository;
    }

    private static Loader getLoader(Integer choice) {
        Loader loader = null;

        switch (choice) {
            case 1:
                loader = DataService.getInstance().getOwnerLoader();
                break;
            case 2:
                loader = DataService.getInstance().getHorseLoader();
                break;
            case 3:
                loader = DataService.getInstance().getJockeyLoader();
                break;
            case 4:
                loader = DataService.getInstance().getHippodromeLoader();
                break;
            case 5:
                loader = DataService.getInstance().getResultRaceLoader();
                break;
            case 6:
                loader = DataService.getInstance().getRacesLoader();
                break;
            case 7:
                loader = null;
                logger.info("Back to menu");
                break;
            default:
                logger.error("Wrong choice");
                break;
        }

        return loader;
    }

}
