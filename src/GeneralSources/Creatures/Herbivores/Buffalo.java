package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Buffalo extends Creature {
    public Buffalo() {
        super(BUFFALO, 3, 1, 700, 100);
        setMaxCreatures(10);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
