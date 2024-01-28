package ca.mcmaster.se2aa4.mazerunner;

public class RightHand extends Runner implements Algorithm {
    private Maze maze;
    private String[][] mazeLayout;
    private SpaceFormatter formatter = new SpaceFormatter();
    private String canonicalPath;
    private String factorizedPath;
    private FactorizedPath factor = new FactorizedPath();

    public RightHand(Maze maze) {
        x = maze.getStartX();
        y = maze.getStartY();

        if (maze.getReverse() == false) {
            currentDirection = 'E';
        }

        else {
            currentDirection = 'W';
        }
        
        this.maze = maze;
        mazeLayout = maze.getMaze();
    }

    //Algorithm: Turn right, check forward, if forward is clear move forward, else turn left and check forward, and keep turning left and checking forward if forward not clear until you can move forward
    public String navigate() {
        canonicalPath = "";

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

        //canonicalPath = formatter.format(canonicalPath);

        //factorizedPath = factor.convert(canonicalPath);

        return canonicalPath;
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public String getFactorizedPath() {
        return factorizedPath;
    }
}
