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
    private boolean reverse;

    public Maze(String inputFile, boolean reverse) {
        this.inputFile = inputFile;
        this.reverse = reverse;
    }

    public void generate() {
        width = findWidth();
        height = findHeight();

        maze = new String[height][width];

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

            if (reverse == false) {
                startX = 0;
                endX = width - 1;
            }

            else {
                startX = width - 1;
                endX = 0;
            }

            findStart();
            findEnd();
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
        for (int i = 0; i < height; i++) {
            if (maze[i][startX].equals(" ")) {
                startY = i;
                break;
            }
        }
    }

    private void findEnd() {
        for (int i = 0; i < height; i++) {
            if (maze[i][endX].equals(" ")) {
                endY = i;
                break;
            }
        }
    }

    public String[][] getMaze() {
        return maze;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public boolean getReverse() {
        return reverse;
    }
}
