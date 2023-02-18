package GeneralSources.Creatures;

import GeneralSources.Creatures.Actions.Dying;
import GeneralSources.Creatures.Actions.Eating;
import GeneralSources.Creatures.Actions.Movement;
import GeneralSources.Creatures.Actions.Reproduction;

import java.util.List;


public abstract class Creature implements Eating, Movement, Reproduction, Dying, Randomizer {

    private CreatureTypes creatureType;
  // private CreatureCount maxCount;
    private int speed, hp, move;
    private int maxCreatures;
    private double weight;
    private double satiety, currentSatiety;
    private CreaturesFactory factory = new CreaturesFactory();
    private List<CreatureTypes> hunting;
    private List<CreatureTypes> eatingList;
    private List<Integer> eatingListChance;


    public Creature(CreatureTypes creatureType, /*CreatureCount maxCount,*/ int speed, int hp, double weight, double satiety) {
     //   this.maxCount = maxCount;
        this.creatureType = creatureType;
        this.speed = speed;
        this.hp = hp;
        this.weight = weight;
        this.satiety = satiety;
        currentSatiety = satiety * 0.50;
        move = 1;
    }


    public CreatureTypes getCreatureType() {
        return creatureType;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public double getSatiety() {
        return satiety;
    }

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public int getMaxCreatures() {
        return maxCreatures;
    }

    public void setMaxCreatures(int maxCreatures) {
        this.maxCreatures = maxCreatures;
    }

    public List<CreatureTypes> getHunting() {
        return hunting;
    }

    public void setHunting(List<CreatureTypes> hunting) {
        this.hunting = hunting;
    }

    public List<CreatureTypes> getEatingList() {
        return eatingList;
    }

    public void setEatingList(List<CreatureTypes> eatingList) {
        this.eatingList = eatingList;
    }

    public List<Integer> getEatingListChance() {
        return eatingListChance;
    }

    public void setEatingListChance(List<Integer> eatingListChance) {
        this.eatingListChance = eatingListChance;
    }

    @Override
    public void eat(double food) {
        if (food >= satiety) {
            currentSatiety = satiety;
        } else if (food < satiety) {
            if ((currentSatiety + food) >= satiety) {
                currentSatiety = satiety;
            } else {
                currentSatiety += food;
            }
        }
    }


    @Override
    public int move() {
        return toRandom(speed);
    }

    @Override
    public Creature reproduction() {
        return factory.createCreature(getCreatureType());
    }

    @Override
    public boolean isDead() {
        return hp > 0;
    }


}

