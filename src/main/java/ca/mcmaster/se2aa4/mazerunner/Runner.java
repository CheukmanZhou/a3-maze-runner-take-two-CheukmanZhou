package ca.mcmaster.se2aa4.mazerunner;

public class Runner {
    private int x;
    private int y;
    private char currentDirection;

    public Runner(Maze maze) {
        x = maze.getStartX();
        y = maze.getStartY();
        currentDirection = 'E';
    }

    //move() moves the runner forward in the direction that it is facing
    private void move() {
        //Move North
        if (currentDirection == 'N') {
            y++;
        }

        //Move South
        else if (currentDirection == 'S') {
            y--;
        }

        //Move East
        else if (currentDirection == 'E') {
            x++;
        }

        //Move West
        else {
            x--;
        }
    }

    private void turnRight() {

    }

    private void turnLeft() {

    }
}
