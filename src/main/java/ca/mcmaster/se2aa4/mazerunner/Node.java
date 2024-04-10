package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Position position;
    private List<Node> neighbors;

    public Node(Position position) {
        this.position = position;
        this.neighbors = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
