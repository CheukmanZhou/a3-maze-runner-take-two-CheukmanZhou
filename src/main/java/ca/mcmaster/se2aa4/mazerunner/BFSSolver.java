package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSSolver implements MazeSolver {
    @Override
    public Path solve(Maze maze) {
        // Initialize the queue for BFS
        Queue<Node> queue = new LinkedList<>();
        // Initialize a set to keep track of visited positions
        Set<Position> visited = new HashSet<>();
        // Initialize the starting position
        Position start = maze.getStart();
        // Add the starting position to the queue
        queue.offer(new Node(start, null));

        // Perform BFS
        while (!queue.isEmpty()) {
            // Get the current node from the queue
            Node current = queue.poll();
            // Check if we have reached the exit
            if (current.position.equals(maze.getEnd())) {
                return reconstructPath(current, start); // Return the reconstructed path to the exit
            }
            // Mark the current position as visited
            visited.add(current.position);
            // Explore neighbors of the current position
            for (Direction dir : Direction.values()) {
                // Calculate the neighbor position
                Position neighbor = current.position.move(dir);
                // Check if the neighbor position is within the maze and not a wall
                if (isValidPosition(maze, neighbor) && !visited.contains(neighbor)) {
                    // Add the neighbor position to the queue
                    queue.offer(new Node(neighbor, current));
                }
            }
        }
        // If no path to the exit is found, return null
        return null;
    }

    // Helper method to check if a position is valid (within the maze boundaries and not a wall)
    private boolean isValidPosition(Maze maze, Position pos) {
        return pos.getX() >= 0 && pos.getY() >= 0 &&
                pos.getX() < maze.getSizeX() && pos.getY() < maze.getSizeY() &&
                !maze.isWall(pos);
    }

    private Path reconstructPath(Node endNode, Position start) {
        List<Position> positions = new ArrayList<>();
        Node current = endNode;
        while (current != null) {
            positions.add(current.position);
            current = current.parent;
        }
        Collections.reverse(positions);
        return translatePositions(positions, start);
    }

    private Path translatePositions(List<Position> positions, Position start) {
        Path path = new Path();
        Direction dir = Direction.RIGHT;
        Position current = start;
        for (Position pos : positions) {
            if (pos.equals(current.check(dir))) {
                path.addStep('F');
                current = pos;
            }

            else if (pos.equals(current.check(dir.turnRight()))) {
                path.addStep('R');
                path.addStep('F');
                dir = dir.turnRight();
                current = pos;
            }

            else if (pos.equals(current.check(dir.turnLeft()))) {
                path.addStep('L');
                path.addStep('F');
                dir = dir.turnLeft();
                current = pos;
            }
        }

        return path;
    }
}
