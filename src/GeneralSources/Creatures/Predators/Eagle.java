package GeneralSources.Creatures.Predators;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Eagle extends Creature {
    public Eagle() {
        super(EAGLE, 3, 1, 6, 1);
        setMaxCreatures(20);
        setEatingList(List.of(FOX, RABBIT, MOUSE, DUCK));
        setEatingListChance(List.of(10, 90, 90, 80));
    }
}


