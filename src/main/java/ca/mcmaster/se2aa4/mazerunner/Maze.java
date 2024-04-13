package ca.mcmaster.se2aa4.mazerunner;

public interface Maze {
    Position getStart();
    Position getEnd();
    Boolean isWall(Position pos);
    int getSizeX();
    int getSizeY();
}
