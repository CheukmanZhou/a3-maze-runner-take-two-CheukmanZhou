package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathValidator {
    private static final Logger logger = LogManager.getLogger();
    
    private Maze maze;

    public PathValidator(Maze maze) {
        this.maze = maze;
    }
    
    /**
     * Check if path is valid for Maze.
     *
     * @param path The path to valid
     * @return If path is valid
     */
    public Boolean validatePath(Path path) {
        return validatePathDir(path, maze.getStart(), Direction.RIGHT, maze.getEnd()) || validatePathDir(path, maze.getEnd(), Direction.LEFT, maze.getStart());
    }

    /**
     * Check if path is valid from starting to end position.
     *
     * @param path Path
     * @param startPos Starting position
     * @param startDir Starting direction
     * @param endPos Ending position
     * @return If path is valid
     */
    private Boolean validatePathDir(Path path, Position startPos, Direction startDir, Position endPos) {
        Position pos = startPos;
        Direction dir = startDir;
        for (char c : path.getPathSteps()) {
            switch (c) {
                case 'F' -> {
                    pos = pos.move(dir);

                    if (pos.x() >= maze.getSizeX() || pos.y() >= maze.getSizeY() || pos.x() < 0 || pos.y() < 0) {
                        return false;
                    }
                    if (maze.isWall(pos)) {
                        return false;
                    }
                }
                case 'R' -> dir = dir.turnRight();
                case 'L' -> dir = dir.turnLeft();
            }
            logger.debug("Current Position: " + pos);
        }

        return pos.equals(endPos);
    }
}
