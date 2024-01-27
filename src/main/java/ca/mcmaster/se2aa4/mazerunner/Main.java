package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        ReadFile read = new ReadFile(args);
        Maze maze = new Maze(read.getInputFile());
        maze.generate();
        Runner runner = new Runner(maze);
        RightHand rightHand = new RightHand(runner, maze);
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
