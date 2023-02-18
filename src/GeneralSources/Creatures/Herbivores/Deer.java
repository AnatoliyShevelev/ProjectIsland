package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Deer extends Creature {
    public Deer() {
        super(DEER, 4, 1, 300, 60);
        setMaxCreatures(20);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
