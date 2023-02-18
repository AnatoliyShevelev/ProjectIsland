package GeneralSources.Creatures.Plants;

import GeneralSources.Creatures.Creature;

import static GeneralSources.Creatures.CreatureTypes.*;

public class Plant extends Creature {
    public Plant() {
        super(PLANT, 0, 1, 1, 0);
        setMaxCreatures(200);
        setMove(0);
    }
}
