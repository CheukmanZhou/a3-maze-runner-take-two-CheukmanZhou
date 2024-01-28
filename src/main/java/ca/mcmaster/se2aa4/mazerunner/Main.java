package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        ReadFile read = new ReadFile(args);
        
        //Regular Path
        Maze mazeReg = new Maze(read.getInputFile(), false);
        mazeReg.generate();
        RightHand reg = new RightHand(mazeReg);

        //Reverse Path
        Maze mazeRev = new Maze(read.getInputFile(), true);
        mazeRev.generate();
        RightHand rev = new RightHand(mazeRev);
        
        logger.info("**** Computing path");
        
        System.out.println("\nRegular Path:");
        System.out.println(reg.navigate());
        System.out.println(reg.getFactorizedPath());

        System.out.println("\nReverse Path:");
        System.out.println(rev.navigate());
        System.out.println(rev.getFactorizedPath());

        if (read.getPath() != "") {
            CheckPath checkPath = new CheckPath();
            System.out.println("\n" + checkPath.check(reg.getCanonicalPath(), reg.getFactorizedPath(), rev.getCanonicalPath(), rev.getFactorizedPath(), read.getPath()));
        }

        else {
            System.out.println();
        }

        logger.info("** End of Maze Runner");
    }
}
