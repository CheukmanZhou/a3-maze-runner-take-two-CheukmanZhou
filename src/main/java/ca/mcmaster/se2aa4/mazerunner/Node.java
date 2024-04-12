package ca.mcmaster.se2aa4.mazerunner;

public class Node {
    Position position; // Position in the maze
    Node parent; // Parent node in the path

    Node(Position position, Node parent) {
        this.position = position;
        this.parent = parent;
    }
}
