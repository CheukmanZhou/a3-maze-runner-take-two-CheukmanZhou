package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        ReadFile read = new ReadFile(args);
        
        Maze mazeReg = new Maze(read.getInputFile(), false);
        mazeReg.generate();
        RightHand reg = new RightHand(mazeReg);
        System.out.println(reg.navigate());
        System.out.println(reg.getFactorizedPath());

        Maze mazeRev = new Maze(read.getInputFile(), true);
        mazeRev.generate();
        RightHand rev = new RightHand(mazeRev);
        System.out.println(rev.navigate());
        System.out.println(rev.getFactorizedPath());

        CheckPath checkPath = new CheckPath();

        System.out.println(checkPath.check(reg.getCanonicalPath(), reg.getFactorizedPath(), rev.getCanonicalPath(), rev.getFactorizedPath(), read.getPath()));

        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
