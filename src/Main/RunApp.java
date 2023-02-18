package Main;

import GeneralSources.Logics.CreatePlantsLogic;
import GeneralSources.Logics.StatisticsLogic;
import GeneralSources.Logics.DyingLogic;
import GeneralSources.Logics.MainLogic;
import GeneralSources.World.Island;

public class RunApp implements Runnable {
    Island island;
    Launching launching;
    MainLogic mainLogic;
    CreatePlantsLogic createPlantsLogic = new CreatePlantsLogic();
    DyingLogic dyingLogic = new DyingLogic();
    StatisticsLogic statisticsLogic = new StatisticsLogic();

    @Override
    public void run() {
        launching = new Launching();
        launching.launch();
        island = launching.getIsland();
        mainLogic = new MainLogic(island);
        while(island.populating()) {
            mainLogic.openIsland();
            dyingLogic.startClearIsland(island);
            statisticsLogic.launchLogic(island);
            createPlantsLogic.openIsland(island);
        }
        System.out.println("Live Dead");
    }
}
