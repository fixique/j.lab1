package edu.core.java.races.additional;

import edu.core.java.races.loader.*;
import edu.core.java.races.repository.*;
import edu.core.java.races.translator.*;

/**
 * Created by Ubeto on 20.05.17.
 */
public class DataService {

    private static DataService instance;

    static {
        instance = new DataService();
        instance.Init();
    }

    public static DataService getInstance() { return instance; }

    private DataService() {}

    private void Init() {

        ownerRepository = new OwnerRepository();
        horseRepository = new HorseRepository();
        jockeyRepository = new JockeyRepository();
        hippodromeRepository = new HippodromeRepository();
        resultRaceRepository = new ResultRaceRepository();
        racesRepository = new RacesRepository();

        ownerTranslator = new OwnerTranslator();
        horseTranslator = new HorseTranslator();
        jockeyTranslator = new JockeyTranslator();
        hippodromeTranslator = new HippodromeTranslator();
        resultRaceTranslator = new ResultRaceTranslator();
        racesTranslator = new RacesTranslator();

        ownerLoader = new OwnerLoader(ownerRepository, ownerTranslator);
        horseLoader = new HorseLoader(horseRepository, horseTranslator, ownerLoader);
        jockeyLoader = new JockeyLoader(jockeyRepository, jockeyTranslator);
        hippodromeLoader = new HippodromeLoader(hippodromeRepository, hippodromeTranslator);
        resultRaceLoader = new ResultRaceLoader(resultRaceRepository, resultRaceTranslator, jockeyLoader, horseLoader);
        racesLoader = new RacesLoader(racesRepository, racesTranslator, hippodromeLoader, resultRaceLoader);
    }

    private OwnerRepository ownerRepository;
    private HorseRepository horseRepository;
    private JockeyRepository jockeyRepository;
    private HippodromeRepository hippodromeRepository;
    private ResultRaceRepository resultRaceRepository;
    private RacesRepository racesRepository;

    private OwnerTranslator ownerTranslator;
    private HorseTranslator horseTranslator;
    private JockeyTranslator jockeyTranslator;
    private HippodromeTranslator hippodromeTranslator;
    private ResultRaceTranslator resultRaceTranslator;
    private RacesTranslator racesTranslator;

    private OwnerLoader ownerLoader;
    private HorseLoader horseLoader;
    private JockeyLoader jockeyLoader;
    private HippodromeLoader hippodromeLoader;
    private ResultRaceLoader resultRaceLoader;
    private RacesLoader racesLoader;

    public OwnerRepository getOwnerRepository() { return ownerRepository; }
    public HorseRepository getHorseRepository() { return horseRepository; }
    public JockeyRepository getJockeyRepository() { return jockeyRepository; }
    public HippodromeRepository getHippodromeRepository() { return hippodromeRepository; }
    public ResultRaceRepository getResultRaceRepository() { return resultRaceRepository; }
    public RacesRepository getRacesRepository() { return racesRepository; }

    public OwnerTranslator getOwnerTranslator() { return ownerTranslator; }
    public HorseTranslator getHorseTranslator() { return horseTranslator; }
    public JockeyTranslator getJockeyTranslator() { return jockeyTranslator; }
    public HippodromeTranslator getHippodromeTranslator() { return hippodromeTranslator; }
    public ResultRaceTranslator getResultRaceTranslator() { return resultRaceTranslator; }
    public RacesTranslator getRacesTranslator() { return racesTranslator; }

    public OwnerLoader getOwnerLoader() { return ownerLoader; }
    public HorseLoader getHorseLoader() { return horseLoader; }
    public JockeyLoader getJockeyLoader() { return jockeyLoader; }
    public HippodromeLoader getHippodromeLoader() { return hippodromeLoader; }
    public ResultRaceLoader getResultRaceLoader() { return resultRaceLoader; }
    public RacesLoader getRacesLoader() { return racesLoader; }
}
