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
        //East to South
        if (currentDirection == 'E') {
            currentDirection = 'S';
        }

        //South to West
        else if (currentDirection == 'S') {
            currentDirection = 'W';
        }

        //West to North
        else if (currentDirection == 'W') {
            currentDirection = 'N';
        }

        //North to East
        else {
            currentDirection = 'E';
        }
    }

    private void turnLeft() {
        //East to North
        if (currentDirection == 'E') {
            currentDirection = 'N';
        }

        //North to West
        else if (currentDirection == 'N') {
            currentDirection = 'W';
        }

        //West to South
        else if (currentDirection == 'W') {
            currentDirection = 'S';
        }

        //South to East
        else {
            currentDirection = 'E';
        }
    }
}
