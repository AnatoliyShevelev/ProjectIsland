package GeneralSources.Logics;

import GeneralSources.Creatures.Creature;
import GeneralSources.Creatures.CreatureTypes;
import GeneralSources.World.Cells.CellMap;
import GeneralSources.World.Island;

import java.util.List;
import java.util.Map;

public class MainLogic {

    int coordinateX, coordinateY;
    private EatingLogic eatingLogic = new EatingLogic();
    private MovementLogic movementLogic = new MovementLogic();
    ReproductionLogic reproductionLogic = new ReproductionLogic();
    private Creature object;
    private Island island;
    private CellMap[][] cellMaps;
    private CellMap cell;

    public MainLogic(Island island) {
        this.island = island;
    }

    private void launchBasicLogic() {
        if (object.isDead() && object.getMove() > 0) {
            object.setMove(0);
           // System.out.println(object.getCreatureType()+ " Launch BasicLogic");
            if (object.getCreatureType() != CreatureTypes.PLANT) {
                if (object.getCurrentSatiety() >= (object.getSatiety() * 0.81)) {
                    //Start reproduction logic.
                    if (reproductionLogic.startReproduction(object, cell) == 0) {
                        return;
                    } else {
                        if (object.getCreatureType() != CreatureTypes.CATERPILLAR)
                            if (object.toRandom(100) > 50) {
                                movementLogic.startMove(0, coordinateX, coordinateY, object, cellMaps);
                            } else {
                                movementLogic.startMove(1, coordinateX, coordinateY, object, cellMaps);
                            }
                    }

                } else {
                    //Start eating logic.
                    if (eatingLogic.startEating(object, cell) == 0) {
                        return;
                    } else {
                        if (object.getCreatureType() != CreatureTypes.CATERPILLAR)
                            if (object.toRandom(100) > 50) {
                                movementLogic.startMove(0, coordinateX, coordinateY, object, cellMaps);
                            } else {
                                movementLogic.startMove(1, coordinateX, coordinateY, object, cellMaps);
                            }
                    }

                }
            }
        }
    }
    public void openIsland() {
        cellMaps = island.getCellsArray();
        readCell();
    }

    private void openCell() {
        CreatureTypes[] type = CreatureTypes.values();
        Map<CreatureTypes, List<Creature>> creatureMap = cell.getMapCreature();
        for (int i = 0; i < type.length; i++) {
            List<Creature> creatureList = creatureMap.get(type[i]);
            for (int j = 0; j < creatureList.size(); j++) {
                if (!creatureList.isEmpty()) {
                    object = creatureList.get(j);
                    launchBasicLogic();
                }
            }

        }
    }

    private void readCell() {
        for (int i = 0; i < cellMaps.length; i++) {
            for (int j = 0; j < cellMaps[i].length; j++) {
                coordinateX = i;
                coordinateY = j;
                cell = cellMaps[i][j];
                openCell();
            }
        }
    }
}
