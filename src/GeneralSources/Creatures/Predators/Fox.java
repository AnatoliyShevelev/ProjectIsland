package GeneralSources.Creatures.Predators;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Fox extends Creature {
    public Fox() {
        super(FOX, 2, 1, 8, 2);
        setMaxCreatures(30);
        setEatingList(List.of(RABBIT, MOUSE, DUCK, CATERPILLAR));
        setEatingListChance(List.of(70, 90, 60, 40));
    }
}
