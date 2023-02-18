package GeneralSources.Creatures.Predators;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Boa extends Creature {
    public Boa() {
        super(BOA, 1, 1, 15, 3);
        setMaxCreatures(30);
        setEatingList(List.of(FOX, RABBIT, MOUSE, DUCK));
        setEatingListChance(List.of(15, 20, 40, 10));
    }
}
