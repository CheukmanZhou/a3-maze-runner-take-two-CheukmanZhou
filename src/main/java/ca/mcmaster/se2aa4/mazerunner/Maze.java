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
    private int startX;
    private int startY;
    private int endX;
    private int endY;

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

            findStart();
            findEnd();

            ////////////Tester
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    System.out.print(maze[row][col]);
                }
                System.out.println();
            }

            System.out.println("Start Position: " + startX + ", " + startY);
            System.out.println("End Position: " + endX + ", " + endY);

            //////////////


        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
    }

    private int findWidth() {
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

    private int findHeight() {
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

    private void findStart() {
        startX = 0;

        for (int i = 0; i < height; i++) {
            if (maze[i][0].equals(" ")) {
                startY = i;
                break;
            }
        }
    }

    private void findEnd() {
        endX = width - 1;

        for (int i = 0; i < height; i++) {
            if (maze[i][width - 1].equals(" ")) {
                endY = i;
                break;
            }
        }
    }
}
