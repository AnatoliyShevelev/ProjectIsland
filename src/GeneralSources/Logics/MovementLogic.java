package GeneralSources.Logics;

import GeneralSources.Creatures.Creature;
import GeneralSources.World.Cells.CellMap;

public class MovementLogic {

    private int x, y;

    public void startMove(int direction, int corX, int corY, Creature object, CellMap[][] cellMap) {
        // System.out.println("Move -> " + object.getCreatureType());
        // System.out.println(object.getCurrentSatiety());
        x = corX;
        y = corY;
        int turn = object.move();
        // System.out.println("Step ->" + turn);
        if (turn == 0) {
            turn = 1;
        }
        //System.out.println("Step ->" + turn);
        if (direction == 0) {
            //  System.out.println("Corx");
            if (cellMap.length >= (x + turn)) {
                while (turn > 0) {
                    if (turnOnRight(cellMap.length, turn)) {
                        startMoveCorX(y, object, cellMap, x + turn);
                        break;
                    } else {
                        turn--;
                    }
                }
            } else if (cellMap.length < (x + turn)) {
                while (turn > 0) {
                    if (turnOnLeft(turn)) {
                        startMoveCorX(y, object, cellMap, x - turn);
                        break;
                    } else {
                        turn--;
                    }

                }

            }
        } else if (direction == 1) {
            //System.out.println("CorY");
            if (cellMap[x].length >= (y + turn)) {
                while (turn > 0) {
                    if (turnOnBottom(cellMap[x].length, turn)) {
                        startMoveCorY(x, object, cellMap, turn);
                        break;
                    } else {
                        turn--;
                    }
                }
            } else if (cellMap[x].length < (y + turn)) {
                while (turn > 0) {
                    if (turnOnTop(turn)) {
                        startMoveCorY(x, object, cellMap, turn);
                        break;
                    } else {
                        turn--;
                    }
                }
            }
        }
        cellMap[x][y].getMapCreature().get(object.getCreatureType()).remove(object);
    }

    private boolean turnOnLeft(int turn) {
        return (x - turn) >= 0;
    }

    private boolean turnOnRight(int length, int turn) {
        return (length - (x + turn)) >= turn;
    }

    private boolean turnOnTop(int turn) {
        return (y - turn) >= 0;
    }

    private boolean turnOnBottom(int length, int turn) {
        return (length - (y + turn)) >= turn;
    }

    public void startMoveCorX(int corY, Creature object, CellMap[][] cellMap, int turn) {
        if (cellMap[turn][corY].getMapCreature().get(object.getCreatureType()).size() < object.getMaxCreatures()) {
            cellMap[turn][corY].getMapCreature().get(object.getCreatureType()).add(object);
            object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.2));
        } else {
            object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.2));
        }

    }

    public void startMoveCorY(int corX, Creature object, CellMap[][] cellMap, int turn) {
        if (cellMap[corX][turn].getMapCreature().get(object.getCreatureType()).size() < object.getMaxCreatures()) {
            cellMap[corX][turn].getMapCreature().get(object.getCreatureType()).add(object);
            object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.2));
        } else {
            object.setCurrentSatiety(object.getCurrentSatiety() - (object.getSatiety() * 0.2));
        }

    }
}
