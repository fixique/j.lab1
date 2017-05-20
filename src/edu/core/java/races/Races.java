package edu.core.java.races;

import edu.core.java.races.additional.IncrementId;
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
    private static Scanner scanner;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static IncrementId ownerId = new IncrementId();
    private static IncrementId horseId = new IncrementId();
    private static IncrementId jockeyId = new IncrementId();
    private static IncrementId hippodromeId = new IncrementId();
    private static IncrementId ResultRaceId = new IncrementId();
    private static IncrementId RaceId = new IncrementId();

    private static ObjectMapper mapper = new ObjectMapper();

    public static void start() {
        logger.info("Application has started");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("______________________________________");
            System.out.println("1. Add entity");
            System.out.println("2. Update entity");
            System.out.println("3. Delete entity");
            System.out.println("4. Show entity");
            System.out.println("5. Show all entities");
            System.out.println("6. Exit app");
            System.out.println("--------------------------------------");
            int choice;

            try {
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        //addEntity();
                        logger.info("Add entity");
                        break;
                    case 2:
                        //updateEntity();
                        logger.info("Update Entity");
                        break;
                    case 3:
                        //deleteEntity();
                        logger.info("Delete Entity");
                        break;
                    case 4:
                        //showEntity();
                        logger.info("Show entity");
                        break;
                    case 5:
                        //showAllEntity();
                        logger.info("Show all entities");
                        break;
                    case 6:
                        logger.info("Application has stopped");
                        return;
                    default:
                        logger.warn("Incorrect choice");
                }

            } catch (NumberFormatException | IOException ex) {
                logger.error(ex.getMessage());
            }
        }
    }


}
