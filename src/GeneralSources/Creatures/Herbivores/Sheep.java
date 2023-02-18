package GeneralSources.Creatures.Herbivores;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Sheep extends Creature {

    public Sheep() {
        super(SHEEP, 3, 1, 70, 15);
        setMaxCreatures(140);
        setEatingList(List.of(PLANT));
        setEatingListChance(List.of(100));
    }
}
