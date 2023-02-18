package GeneralSources.World.Cells;

import GeneralSources.Creatures.*;
import GeneralSources.World.Create;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellMap extends MaxOnCell implements Create, Randomizer {

    private CreatureTypes allCreatureTypes;
    private CreatureCount creatureCount;
    Map<CreatureTypes, List<Creature>> mapCreature = new HashMap<>();
    public CreaturesFactory creaturesFactory = new CreaturesFactory();


    private List<Creature> createCreature(CreatureTypes type, int count) {
        List<Creature> creatureList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            creatureList.add(creaturesFactory.createCreature(type));
        }
        return creatureList;
    }

    public Map<CreatureTypes, List<Creature>> getMapCreature() {
        return mapCreature;
    }

    private void createCreatureInCell() {
        CreatureTypes[] types = allCreatureTypes.values();
        CreatureCount[] count = creatureCount.values();
        for (int i = 0; i < types.length; i++) {
            mapCreature.put(types[i], createCreature(types[i], toRandom(count[i].getCount())));
        }
    }

    @Override
    public void create() {
        createCreatureInCell();
    }
}
