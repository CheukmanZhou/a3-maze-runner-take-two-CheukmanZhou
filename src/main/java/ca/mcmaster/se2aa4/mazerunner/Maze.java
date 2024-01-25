package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private int width;
    private int height;
    private final String inputFile;
    private String[][] maze;
    private String startX;
    private String startY;
    private String endX;
    private String endY;

    public Maze(String inputFile) {
        this.inputFile = inputFile;
    }

    public void generate() {
        width = findWidth();
        height = findHeight();

        maze = new String[width][height];

        logger.info("**** Reading the maze from file " + inputFile);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            for (int row = 0; row < height; row++) {
                line = reader.readLine();
                for (int col = 0; col < width; col++) {
                    try {
                        maze[row][col] = Character.toString(line.charAt(col));
                    } catch (Exception e) {
                        maze[row][col] = " ";
                    }
                }
            }

            ////////////Tester
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    System.out.print(maze[row][col]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
    }

    public int findWidth() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            line = reader.readLine();

            return line.length();
        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
            return 0;
        }
    }

    public int findHeight() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            int height = 0;

            while ((line = reader.readLine()) != null) {
                height++;
            }

            return height;
        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
            return 0;
        }
    }

    public void findStart() {

    }

    public void findEnd() {

    }
}
