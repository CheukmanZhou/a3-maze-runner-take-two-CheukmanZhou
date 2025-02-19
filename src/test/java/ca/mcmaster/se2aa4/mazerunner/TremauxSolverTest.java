package ca.mcmaster.se2aa4.mazerunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TremauxSolverTest {
    MazeExporter exporter = new Maze2DArrayListExporter();
    MazeSolver solver = new TremauxSolver();
    
    @Test
    void solveStraightMazeTest() throws Exception {
        String filePath = "./examples/straight.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("4F", path.getFactorizedForm());
    }
    
    @Test
    void solveSmallMazeTest() throws Exception {
        String filePath = "./examples/small.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("F L F R 2F L 6F R 4F R 2F L 2F R 2F L F", path.getFactorizedForm());
    }

    @Test
    void solveMediumMazeTest() throws Exception {
        String filePath = "./examples/medium.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("F L 2F R 2F L 18F L 2F R 2F R 8F R 2F L 6F R 10F L 4F R 10F L 10F R 4F L F", path.getFactorizedForm());
    }

    @Test
    void solveLargeMazeTest() throws Exception {
        String filePath = "./examples/large.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("15F R 2F L 8F R 2F L 4F R 2F L 4F R 4F L 6F R 2F L 2F R 2F L 2F R 2F L 2F R 2F L 2F R 2F L 2F R 6F L 2F L 2F R F", path.getFactorizedForm());
    }
}
