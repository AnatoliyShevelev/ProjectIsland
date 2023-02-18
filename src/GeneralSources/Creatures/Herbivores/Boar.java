package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Boar extends Creature {
    public Boar() {
        super(BOAR, 2, 1, 400, 50);
        setEatingList(List.of(MOUSE, CATERPILLAR, PLANT));
        setEatingListChance(List.of(50, 90, 100));
    }
}
