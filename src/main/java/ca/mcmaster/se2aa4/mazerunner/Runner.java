package ca.mcmaster.se2aa4.mazerunner;

public class Runner {
    private int x;
    private int y;
    private char currentDirection;

    public Runner(int startX, int startY) {
        x = startX;
        y = startY;
        currentDirection = 'E';
    }

    //move() moves the runner forward in the direction that it is facing
    public void move() {
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

    //turns the runner (changes direction)
    public void turn() {

    }

    //Has the if statements changing the current direction based on where the runner turns
    public void direction() {

    }
}
