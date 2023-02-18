package GeneralSources.Creatures.Predators;

import GeneralSources.Creatures.Creature;
import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Wolf extends Creature {
    public Wolf() {
        super(WOLF, 3, 1, 50, 8);
        setMaxCreatures(30);
        setEatingList(List.of(HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK));
        setEatingListChance(List.of(10, 15, 60, 80, 60, 70, 15, 10, 40));
    }
}
