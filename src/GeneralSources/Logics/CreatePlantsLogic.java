package GeneralSources.Logics;

import GeneralSources.Creatures.CreatureCount;
import GeneralSources.Creatures.CreatureTypes;
import GeneralSources.Creatures.CreaturesFactory;
import GeneralSources.Creatures.Randomizer;
import GeneralSources.World.Cells.CellMap;
import GeneralSources.World.Island;

public class CreatePlantsLogic implements Randomizer {
    CreaturesFactory animalFactory = new CreaturesFactory();
    Island island;

    public void setIsland(Island island) {
        this.island = island;
    }
    public void openIsland(Island island) {
        CellMap[][] cellMaps = island.getCellsArray();
        for (int i = 0; i < cellMaps.length; i++) {
            for (int j = 0; j < cellMaps[i].length; j++) {
                CellMap cell = cellMaps[i][j];
                if(cell.getMapCreature().get(CreatureTypes.PLANT).size() < CreatureCount.MAX_PLANTS.getCount()) {
                    int size = CreatureCount.MAX_PLANTS.getCount() - cell.getMapCreature().get(CreatureTypes.PLANT).size();
                    int random = toRandom(size);
                    for(int k = 0 ; k < random; k++)
                        cell.getMapCreature().get(CreatureTypes.PLANT).add(animalFactory.createCreature(CreatureTypes.PLANT));
                }
            }
        }
    }
}
