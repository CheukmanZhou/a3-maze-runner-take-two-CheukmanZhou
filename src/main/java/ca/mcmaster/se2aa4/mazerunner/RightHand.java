package ca.mcmaster.se2aa4.mazerunner;

public class RightHand extends Runner implements Algorithm {
    public RightHand(Maze maze) {
        x = maze.getStartX();
        y = maze.getStartY();
        currentDirection = 'E';
    }

    //Algorithm: Turn right, check forward, if forward is clear move forward, else turn left and check forward, and keep turning left and checking forward if forward not clear until u can move forward
    public String navigate() {
        return null;
    }
}
