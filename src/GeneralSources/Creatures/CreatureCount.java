package GeneralSources.Creatures;

public enum CreatureCount {

    MAX_WOLF(30),
    MAX_BOA(30),
    MAX_FOX(30),
    MAX_BEAR(5),
    MAX_EAGLE(20),
    MAX_HORSE(20),
    MAX_DEER(20),
    MAX_RABBIT(150),
    MAX_MOUSE(500),
    MAX_GOAT(140),
    MAX_SHEEP(140),
    MAX_BOAR(50),
    MAX_BUFFALO(10),
    MAX_DUCK(200),
    MAX_CATERPILLAR(1000),
    MAX_PLANTS(200);

    private int count;

    CreatureCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}

