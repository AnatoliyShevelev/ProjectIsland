package GeneralSources.Logics;

import GeneralSources.Creatures.Creature;
import GeneralSources.Creatures.CreatureTypes;
import GeneralSources.World.Cells.CellMap;
import GeneralSources.World.Island;

import java.util.List;

public class DyingLogic {
    List<Creature> creatures;
    CreatureTypes[] types = CreatureTypes.values();

    public void startClearIsland(Island island) {
        openIsland(island.getCellsArray());
    }

    private void openIsland(CellMap[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                openCell(cells[i][j]);
            }
        }
    }

    private void openCell(CellMap cells) {
        for (int i = 0; i < types.length; i++) {
            creatures = cells.getMapCreature().get(types[i]);
            clearDeadCreature();
        }
    }

    private void clearDeadCreature() {
        hungryDeath();
        removeDeadCreature();

    }

    private void removeDeadCreature() {
        Creature creature = null;
        if (!creatures.isEmpty()) {
            for (int i = 0; i < creatures.size(); i++) {
                creature = creatures.get(i);
                if (creature.getHp() == 0) {
                    creatures.remove(i);
                } else if (creature == null) {
                    creatures.remove(i);
                }
            }
        }
    }

    private void hungryDeath() {
        if (!creatures.isEmpty())
            for (Creature creature : creatures) {
                if (creature.getCurrentSatiety() < 0.0) {
                    creature.setHp(0);
                } else {
                    creature.setMove(1);
                }
            }
    }
}
