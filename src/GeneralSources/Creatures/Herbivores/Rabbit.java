package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Rabbit extends Creature {
    public Rabbit() {
        super(RABBIT, 2, 1, 2, 0.45);
        setMaxCreatures(150);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
