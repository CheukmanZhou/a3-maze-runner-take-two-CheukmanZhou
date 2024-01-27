package ca.mcmaster.se2aa4.mazerunner;

public class Runner {
    protected int x;
    protected int y;
    protected char currentDirection;

    //move() moves the runner forward in the direction that it is facing
    protected void move() {
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

    protected void turnRight() {
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

    protected void turnLeft() {
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
