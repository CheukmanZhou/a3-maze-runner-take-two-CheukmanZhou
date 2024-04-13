package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze2DArrayListExporter implements MazeExporter {
    private static final Logger logger = LogManager.getLogger();

    private final List<List<Boolean>> maze2DArrayList = new ArrayList<>();

    /**
     * Creates a Maze in a 2D ArrayList format from a file path.
     *
     * @param filePath File path of the maze file
     * @throws Exception If maze cannot be read, or maze has no start or end
     */
    @Override
    public Maze createMaze(String filePath) throws Exception {
        logger.debug("Reading the maze from file " + filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            List<Boolean> newLine = new ArrayList<>();
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    newLine.add(true);
                } else if (line.charAt(idx) == ' ') {
                    newLine.add(false);
                }
            }
            maze2DArrayList.add(newLine);
        }

        reader.close();
        
        Maze maze = new Maze2DArrayList(maze2DArrayList);

        return maze;
    }
}
