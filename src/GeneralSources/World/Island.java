package GeneralSources.World;

import GeneralSources.Creatures.CreatureTypes;
import GeneralSources.World.Cells.CellMap;

public class Island extends World {
    private CellMap[][] cellsArray;

    public Island() {
        this(100, 20);
    }

    public Island(int sizeV, int sizeG) {
        this.sizeV = sizeV;
        this.sizeG = sizeG;
    }

    public CellMap[][] getCellsArray() {
        return cellsArray;
    }

    private void createIsland(int sizeV, int sizeG) {
        cellsArray = new CellMap[sizeV][sizeG];
        for (int i = 0; i < sizeV; i++) {
            for (int j = 0; j < sizeG; j++) {
                cellsArray[i][j] = new CellMap();
                cellsArray[i][j].create();
            }
        }
    }

    public boolean populating() {
        boolean status = false;
        CreatureTypes[] types = CreatureTypes.values();
        for (int i = 0; i < cellsArray.length; i++) {
            for (int j = 0; j < cellsArray[i].length; j++) {
                for (CreatureTypes type : types) {
                    if (type != CreatureTypes.PLANT) {
                        status = !cellsArray[i][j].getMapCreature().get(type).isEmpty();
                        if (status) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void create() {
        createIsland(sizeV, sizeG);
    }
}
