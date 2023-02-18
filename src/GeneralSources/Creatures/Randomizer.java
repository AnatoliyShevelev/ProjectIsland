package GeneralSources.Creatures;

public interface Randomizer {
    default int toRandom(int maxCount) {
        return (int) (Math.random() * maxCount);
    }
}
