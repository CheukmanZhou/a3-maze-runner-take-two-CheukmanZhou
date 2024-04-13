package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BFSSolverTest {
    @Test
    void solve() throws Exception {
        String filePath = "./examples/small.maz.txt";
        MazeExporter exporter = new Maze2DArrayListExporter();
        Maze maze = exporter.createMaze(filePath);
        
        MazeSolver solver = new BFSSolver();
        
        Path path = solver.solve(maze);

        assertEquals("F L F R 2F L 6F R 4F R 2F L 2F R 2F L F", path.getFactorizedForm());
    }
}
