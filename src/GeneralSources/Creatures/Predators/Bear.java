package GeneralSources.Creatures.Predators;

import GeneralSources.Creatures.Creature;

import java.util.List;
import static GeneralSources.Creatures.CreatureTypes.*;

public class Bear extends Creature {
    public Bear() {
        super(BEAR, 2, 1, 500, 80);
      //  super(BEAR, MAX_BEAR, 2, 1, 500, 80);
        setMaxCreatures(5);
        setEatingList(List.of(BOA, HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK));
        setEatingListChance(List.of(80, 40, 80, 80, 90, 70, 70, 50, 20, 10));
    }
}
