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
        competitionRepository = new CompetitionRepository();

        ownerTranslator = new OwnerTranslator();
        horseTranslator = new HorseTranslator();
        jockeyTranslator = new JockeyTranslator();
        hippodromeTranslator = new HippodromeTranslator();
        resultRaceTranslator = new ResultRaceTranslator();
        competitionTranslator = new CompetitionTranslator();

        ownerLoader = new OwnerLoader(ownerRepository, ownerTranslator);
        horseLoader = new HorseLoader(horseRepository, horseTranslator, ownerLoader);
        jockeyLoader = new JockeyLoader(jockeyRepository, jockeyTranslator);
        hippodromeLoader = new HippodromeLoader(hippodromeRepository, hippodromeTranslator);
        competitionLoader = new CompetitionLoader(competitionRepository, competitionTranslator, hippodromeLoader);
        resultRaceLoader = new ResultRaceLoader(resultRaceRepository, resultRaceTranslator, jockeyLoader, horseLoader,competitionLoader);

//        resultRaceLoader = new ResultRaceLoader(resultRaceRepository, resultRaceTranslator, jockeyLoader, horseLoader, competitionLoader);
//        competitionLoader = new CompetitionLoader(competitionRepository, competitionTranslator, hippodromeLoader);
    }

    private OwnerRepository ownerRepository;
    private HorseRepository horseRepository;
    private JockeyRepository jockeyRepository;
    private HippodromeRepository hippodromeRepository;
    private ResultRaceRepository resultRaceRepository;
    private CompetitionRepository competitionRepository;

    private OwnerTranslator ownerTranslator;
    private HorseTranslator horseTranslator;
    private JockeyTranslator jockeyTranslator;
    private HippodromeTranslator hippodromeTranslator;
    private ResultRaceTranslator resultRaceTranslator;
    private CompetitionTranslator competitionTranslator;

    private OwnerLoader ownerLoader;
    private HorseLoader horseLoader;
    private JockeyLoader jockeyLoader;
    private HippodromeLoader hippodromeLoader;
    private ResultRaceLoader resultRaceLoader;
    private CompetitionLoader competitionLoader;

    public OwnerRepository getOwnerRepository() { return ownerRepository; }
    public HorseRepository getHorseRepository() { return horseRepository; }
    public JockeyRepository getJockeyRepository() { return jockeyRepository; }
    public HippodromeRepository getHippodromeRepository() { return hippodromeRepository; }
    public ResultRaceRepository getResultRaceRepository() { return resultRaceRepository; }
    public CompetitionRepository getCompetitionRepository() { return competitionRepository; }

    public OwnerTranslator getOwnerTranslator() { return ownerTranslator; }
    public HorseTranslator getHorseTranslator() { return horseTranslator; }
    public JockeyTranslator getJockeyTranslator() { return jockeyTranslator; }
    public HippodromeTranslator getHippodromeTranslator() { return hippodromeTranslator; }
    public ResultRaceTranslator getResultRaceTranslator() { return resultRaceTranslator; }
    public CompetitionTranslator getCompetitionTranslator() { return competitionTranslator; }

    public OwnerLoader getOwnerLoader() { return ownerLoader; }
    public HorseLoader getHorseLoader() { return horseLoader; }
    public JockeyLoader getJockeyLoader() { return jockeyLoader; }
    public HippodromeLoader getHippodromeLoader() { return hippodromeLoader; }
    public ResultRaceLoader getResultRaceLoader() { return resultRaceLoader; }
    public CompetitionLoader getCompetitionLoader() { return competitionLoader; }
}
