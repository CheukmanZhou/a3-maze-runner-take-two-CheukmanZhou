package ca.mcmaster.se2aa4.mazerunner;

public class RightHand extends Runner implements Algorithm {
    private Maze maze;
    private String[][] mazeLayout;

    public RightHand(Maze maze) {
        x = maze.getStartX();
        y = maze.getStartY();
        currentDirection = 'E';
        this.maze = maze;
        mazeLayout = maze.getMaze();
    }

    //Algorithm: Turn right, check forward, if forward is clear move forward, else turn left and check forward, and keep turning left and checking forward if forward not clear until u can move forward
    public String navigate() {
        String canonicalPath = "";

        while (x != maze.getEndX()) {
            turnRight();
            
            if (check(mazeLayout) == true) {
                canonicalPath = canonicalPath + "R";
                move();
                canonicalPath = canonicalPath + "F";
            }

            else {
                while (true) {
                    turnLeft();
                    
                    if (check(mazeLayout) == true) {
                        move();
                        canonicalPath = canonicalPath + "F";
                        break;
                    }

                    canonicalPath = canonicalPath + "L";
                }
            }
        }

        return canonicalPath;
    }
}
