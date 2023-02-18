package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Mouse extends Creature {
    public Mouse() {
        super(MOUSE, 1, 1, 0.05, 0.01);
        setMaxCreatures(500);
        setEatingList(List.of(CATERPILLAR, PLANT));
        setEatingListChance(List.of(90, 100));
    }
}
