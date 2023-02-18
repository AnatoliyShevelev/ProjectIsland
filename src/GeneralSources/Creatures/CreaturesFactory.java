package GeneralSources.Creatures;

import GeneralSources.Creatures.Herbivores.*;
import GeneralSources.Creatures.Plants.Plant;
import GeneralSources.Creatures.Predators.*;

public class CreaturesFactory {
    public Creature createCreature(CreatureTypes type) {
      Creature creature = switch (type) {
          case WOLF -> new Wolf();
          case BOA -> new Boa();
          case FOX -> new Fox();
          case BEAR -> new Bear();
          case EAGLE -> new Eagle();
          case HORSE -> new Horse();
          case DEER -> new Deer();
          case RABBIT -> new Rabbit();
          case MOUSE -> new Mouse();
          case GOAT -> new Goat();
          case SHEEP -> new Sheep();
          case BOAR -> new Boar();
          case BUFFALO -> new Buffalo();
          case DUCK -> new Duck();
          case CATERPILLAR -> new Caterpillar();
          case PLANT -> new Plant();
          default -> null;
      };
      return creature;
    }
}
