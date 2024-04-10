package ca.mcmaster.se2aa4.mazerunner;

import java.util.HashMap;
import java.util.Map;

public class ConvertToAdjacencyList {
    private Maze maze;
    private int sizeX;
    private int sizeY;

    public ConvertToAdjacencyList(Maze maze) {
        this.maze = maze;
        sizeX = maze.getSizeX();
        sizeY = maze.getSizeY();
    }

    public Map<Position, Node> generateAdjacencyList() {
        Map<Position, Node> adjacencyList = new HashMap<>();

        // Create nodes for each position in the maze
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                Position currentPosition = new Position(x, y);
                Node currentNode = new Node(currentPosition);
                adjacencyList.put(currentPosition, currentNode);
            }
        }

        // Connect neighboring nodes
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                Position currentPosition = new Position(x, y);
                Node currentNode = adjacencyList.get(currentPosition);

                // Check if the current position is not a wall
                if (!maze.isWall(currentPosition)) {
                    // Check neighboring cells for walls
                    if (x > 0 && !maze.isWall(new Position(x - 1, y))) {
                        Node leftNeighbor = adjacencyList.get(new Position(x - 1, y));
                        currentNode.addNeighbor(leftNeighbor);
                    }
                    if (x < sizeX - 1 && !maze.isWall(new Position(x + 1, y))) {
                        Node rightNeighbor = adjacencyList.get(new Position(x + 1, y));
                        currentNode.addNeighbor(rightNeighbor);
                    }
                    if (y > 0 && !maze.isWall(new Position(x, y - 1))) {
                        Node upperNeighbor = adjacencyList.get(new Position(x, y - 1));
                        currentNode.addNeighbor(upperNeighbor);
                    }
                    if (y < sizeY - 1 && !maze.isWall(new Position(x, y + 1))) {
                        Node lowerNeighbor = adjacencyList.get(new Position(x, y + 1));
                        currentNode.addNeighbor(lowerNeighbor);
                    }
                }
            }
        }

        return adjacencyList;
    }
}
