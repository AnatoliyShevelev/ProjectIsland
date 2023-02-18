package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Horse extends Creature {
    public Horse() {
        super(HORSE, 4, 1, 400, 60);
        setMaxCreatures(20);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
