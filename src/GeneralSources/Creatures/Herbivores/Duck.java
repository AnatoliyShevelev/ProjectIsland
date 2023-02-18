package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Duck extends Creature {
    public Duck() {
        super(DUCK, 4, 1, 1, 0.15);
        setMaxCreatures(200);
        setEatingList(List.of(CATERPILLAR, PLANT));
        setEatingListChance(List.of(90, 100));
    }
}
