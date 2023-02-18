package GeneralSources.Logics;

import GeneralSources.Creatures.CreatureTypes;
import GeneralSources.World.Cells.CellMap;
import GeneralSources.World.Island;

import java.util.HashMap;
import java.util.Map;

public class StatisticsLogic {
    private Island island;
    CreatureTypes[] type = CreatureTypes.values();
    Map<CreatureTypes, Integer> mapCount = new HashMap<>();

    private void readDataIsland() {
        readDataArrayCell(island.getCellsArray());
    }

    private void readDataArrayCell(CellMap[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                readDataCell(cells[i][j]);
            }
        }
    }

    private void readDataCell(CellMap cell) {
        for (int i = 0; i < type.length; i++) {
            int count = cell.getMapCreature().get(type[i]).size();
            mapCount.merge(type[i], count, Integer::sum);
        }
    }

    private void writeKeyMap() {
        for (int i = 0; i < type.length; i++) {
            mapCount.put(type[i], 0);
        }
    }

    public StatisticsLogic() {
        writeKeyMap();
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    private void dataOutput() {
        for (int i = 0; i < type.length; i++) {
            System.out.print(type[i] + ": {" + mapCount.get(type[i]) + "} ");
            if (i % 4 == 0 && i > 0) {
                System.out.println();
            } else if (i == type.length - 1) {
                System.out.println();
            }
        }
        System.out.println("------------------------");
        writeKeyMap();
    }

    public void launchLogic(Island is) {
        setIsland(is);
        readDataIsland();
        dataOutput();
    }
}
