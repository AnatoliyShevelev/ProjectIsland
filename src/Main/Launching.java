package Main;

import GeneralSources.World.Island;
import java.util.Scanner;

public class Launching {

    Island island;
    int length, width;

    public Island getIsland() {
        return island;
    }

    public void launch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to project \"Island\"");
        System.out.println("Set the length of the island:");
        length = scanner.nextInt();
        System.out.print("Set the width of the island: ");
        width = scanner.nextInt();
        System.out.println("the island is creating and filled with animals and plants...");
        island = new Island(length, width);
        island.create();
        System.out.println(island.populating());
    }
}
