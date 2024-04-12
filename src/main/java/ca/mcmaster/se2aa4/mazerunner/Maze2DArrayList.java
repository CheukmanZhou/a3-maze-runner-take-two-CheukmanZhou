package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class Maze2DArrayList implements Maze {
    private final List<List<Boolean>> maze;

    private final Position start;
    private final Position end;

    public Maze2DArrayList(List<List<Boolean>> maze2DArrayList) throws Exception {
        maze = maze2DArrayList;
        start = findStart();
        end = findEnd();
    }

    /**
     * Find start position of the maze.
     *
     * @return The start position
     * @throws Exception If no valid start position exists
     */
    private Position findStart() throws Exception {
        for (int i = 0; i < maze.size(); i++) {
            Position pos = new Position(0, i);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("Invalid maze (no start position available)");
    }

    /**
     * Find start end of the maze.
     *
     * @return The end position
     * @throws Exception If no valid end position exists
     */
    private Position findEnd() throws Exception {
        for (int i = 0; i < maze.size(); i++) {
            Position pos = new Position(maze.getFirst().size() - 1, i);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("Invalid maze (no end position available)");
    }

    /**
     * Check if position of Maze is a wall.
     *
     * @param pos The position to check
     * @return If position is a wall
     */
    public Boolean isWall(Position pos) {
        return maze.get(pos.y()).get(pos.x());
    }

    /**
     * Get start position.
     *
     * @return Start position
     */
    public Position getStart() {
        return start;
    }

    /**
     * Get end position.
     *
     * @return End position
     */
    public Position getEnd() {
        return end;
    }

    /**
     * Get horizontal (X) size of Maze.
     *
     * @return Horizontal size
     */
    public int getSizeX() {
        return this.maze.getFirst().size();
    }

    /**
     * Get vertical (Y) size of Maze.
     *
     * @return Vertical size
     */
    public int getSizeY() {
        return this.maze.size();
    }
}
