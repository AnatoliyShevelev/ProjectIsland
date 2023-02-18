package GeneralSources.Logics;

import GeneralSources.Creatures.Creature;
import GeneralSources.World.Cells.CellMap;

import java.util.List;

public class ReproductionLogic {
    public int startReproduction(Creature object, CellMap cell) {
        if (cell.getMapCreature().get(object.getCreatureType()).size() < object.getMaxCreatures()) {
            List<Creature> creatures = cell.getMapCreature().get(object.getCreatureType());
            for (Creature creature : creatures) {
                if (creature.isDead() && creature.getCurrentSatiety() > (creature.getSatiety() * 0.9)) {
                    creatures.add(object.reproduction());
                    object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.5));
                    break;
                }
            }
            object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.5));
            return 0;
        } else {
            return 1;
        }
    }
}
