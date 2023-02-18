package GeneralSources.Logics;

import GeneralSources.Creatures.Creature;
import GeneralSources.World.Cells.CellMap;

import java.util.List;

public class EatingLogic {
    CellMap cellMap;

    public int startEating(Creature object, CellMap cell) {
        cellMap = cell;
        Creature creature = null;
        int typeCreature = object.toRandom(object.getEatingList().size() - 1);
        int percent = object.getEatingListChance().get(typeCreature);
        List<Creature> list = cell.getMapCreature().get(object.getEatingList().get(typeCreature));
        if (list.isEmpty()) {
            for (int i = 0; i < object.getEatingList().size(); i++) {
                if (!cell.getMapCreature().get(object.getEatingList().get(i)).isEmpty()) {
                    list = cell.getMapCreature().get(object.getEatingList().get(i));
                    creature = list.get(object.toRandom(list.size() - 1));
                    break;
                }
            }
        } else {
            creature = list.get(object.toRandom(list.size() - 1));
        }
        if (creature != null && creature.isDead()) {
            if (object.toRandom(100) >= (100 - percent)) {
                object.eat(creature.getWeight());
                creature.setHp(0);
            } else {
                object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.2));
            }
            return 0;
        } else {
            return 1;
        }
    }
}

