package ca.mcmaster.se2aa4.mazerunner;

public class Node {
    Position position;
    Node parent; //Parent Node in the Path

    Node(Position position, Node parent) {
        this.position = position;
        this.parent = parent;
    }
}
