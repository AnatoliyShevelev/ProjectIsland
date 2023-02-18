package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Goat extends Creature {

    public Goat() {
        super(GOAT, 3, 1, 60, 10);
        setMaxCreatures(140);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
