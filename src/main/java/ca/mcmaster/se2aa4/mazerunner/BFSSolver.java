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
        Queue<Node> queue = new LinkedList<>(); //Initialize queue for BFS
        Set<Position> visited = new HashSet<>(); //Initialize set to keep track of visited positions
        
        Position start = maze.getStart();
        queue.offer(new Node(start, null)); //Add the start position to the queue

        //Perform BFS
        while (!queue.isEmpty()) {
            Node current = queue.poll(); //Get the current node from the queue
            
            //Check if we have reached the exit
            if (current.position.equals(maze.getEnd())) {
                return reconstructPath(current, start); //Return the reconstructed path to the exit
            }
            
            visited.add(current.position); //Mark current position as visited
            
            //Explore neighbors of the current position
            for (Direction dir : Direction.values()) {
                Position neighbor = current.position.move(dir);
                
                //Check if the neighbor position is within the maze and not a wall
                if (isValidPosition(maze, neighbor) && !visited.contains(neighbor)) {
                    queue.offer(new Node(neighbor, current)); //Add neighbor position to queue
                }
            }
        }
        
        return null; //If no path to the exit is found, return null
    }

    private boolean isValidPosition(Maze maze, Position pos) {
        return pos.getX() >= 0 && pos.getY() >= 0 && pos.getX() < maze.getSizeX() && pos.getY() < maze.getSizeY() && !maze.isWall(pos);
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
