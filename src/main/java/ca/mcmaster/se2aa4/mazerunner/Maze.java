package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private int width;
    private int length;
    private final String inputFile;
    private String[][] maze;
    private String start;
    private String end;

    public Maze(String inputFile) {
        this.inputFile = inputFile;
    }

    public void generate() {
        logger.info("**** Reading the maze from file " + inputFile);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            ////////////////Need to Modify to input into 2D array
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
    }

    public void findStart() {

    }

    public void findEnd() {

    }
}
