package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Caterpillar extends Creature {
    public Caterpillar() {
        super(CATERPILLAR, 0, 1, 0.01, 0);
        setMaxCreatures(1000);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
