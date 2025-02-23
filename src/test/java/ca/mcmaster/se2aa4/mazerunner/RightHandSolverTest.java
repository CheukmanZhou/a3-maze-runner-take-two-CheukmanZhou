package ca.mcmaster.se2aa4.mazerunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RightHandSolverTest {
    MazeExporter exporter = new Maze2DArrayListExporter();
    MazeSolver solver = new RightHandSolver();
    
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

        assertEquals("F R F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 2F R 4F R 2F R 2F 2R 2F L 2F L 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F R 2F L F", path.getFactorizedForm());
    }

    @Test
    void solveMediumMazeTest() throws Exception {
        String filePath = "./examples/medium.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("F R 6F 2R 8F R 2F R 2F 2R 2F R 2F R 4F R 2F L 4F L 2F 2R 2F R 4F R 2F L 2F R 2F R 4F R 2F 2R 2F L 2F R 2F R 4F R 2F 2R 2F L 2F R 2F 2R 2F R 2F R 2F 2R 4F R 2F R 2F 2R 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 10F R 2F R 8F 2R 8F L 2F R 4F R 2F R 2F 2R 2F R 2F R 14F 2R 12F R 2F R 6F 2R 4F R 2F R 6F R 2F L 6F 2R 6F R 2F R 8F 2R 12F R 2F R 10F 2R 6F R 2F R 4F 2R 4F L 2F R 4F L 2F R 2F L 2F R 2F L 2F R 2F L 4F R 2F R 2F 2R 4F R 2F R 6F R 2F 2R 2F R 2F R 4F 2R 2F R 2F R 4F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F 2R 2F R 2F R 6F L 2F R 8F 2R 8F R 2F R 10F R 4F R 2F 2R 2F R 2F 2R 2F R 2F R 2F L 4F R 2F 2R 4F 2R 2F R 4F R 2F R 2F 2R 4F R 2F R 6F 2R 6F R 4F R 2F R 2F L 2F 2R 2F R 4F R 2F R 2F 2R 2F R 2F R 4F 2R 4F L 4F R 2F R 4F 2R 2F R 2F 2R 2F R 2F R 2F 2R 6F R 2F R 8F R 6F R 2F 2R 2F L 2F R F", path.getFactorizedForm());
    }

    @Test
    void solveLargeMazeTest() throws Exception {
        String filePath = "./examples/large.maz.txt";
        
        Maze maze = exporter.createMaze(filePath);
        
        Path path = solver.solve(maze);

        assertEquals("F R 8F 2R 2F R 2F R 4F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 2F L 8F 2R 6F R 2F R 4F 2R 4F L 2F R 2F R 4F R 8F R 2F L 2F R 2F L 2F 2R 2F R 2F R 2F 2R 4F R 2F L 2F R 2F 2R 2F R 4F R 2F R 2F 2R 2F L 2F R 2F L 2F R 8F R 4F R 2F R 2F L 2F 2R 2F R 4F R 2F R 2F L 2F R 2F 2R 2F R 2F 2R 4F R 2F R 4F 2R 4F R 2F R 6F R 2F L 2F 2R 2F R 2F R 4F R 2F 2R 2F R 2F R 4F L 2F R 2F 2R 2F L 2F R 4F R 4F R 2F R 2F 2R 2F R 4F L 2F 2R 2F R 2F R 4F R 4F R 2F L 2F 2R 2F R 2F R 2F L 4F 2R 4F R 2F R 2F 2R 2F R 2F R 6F R 2F R 2F 2R 2F R 2F L 6F 2R 6F R 4F R 2F R 2F L 4F 2R 4F R 2F L 2F R 2F 2R 2F R 6F R 2F R 2F 2R 6F R 4F R 2F R 2F L 6F R 2F 2R 2F L 6F R 2F R 8F R 2F L 2F 2R 2F R 2F R 2F 2R 2F R 2F R 2F 2R 2F L 2F R 8F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F 2R 2F R 2F L 2F R 2F R 4F R 2F L 2F 2R 2F R 2F L 2F R 2F R 4F R 2F 2R 4F R 2F R 4F 2R 2F R 2F R 2F 2R 2F R 2F R 4F R 4F 2R 2F R 4F L 2F R 2F R 2F L 2F R 2F 2R 2F R 2F L 2F 2R 2F R 4F R 2F R 2F L 2F R 6F L 4F 2R 4F R 2F R 4F 2R 4F R 2F R 2F 2R 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2R 2F L 2F R 2F R 2F 2R 6F R 2F R 2F 2R 2F R 2F 2R 2F R 2F R 4F R 4F R 2F L 2F R 2F L 2F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 2F R 2F R 2F 2R 2F L 2F R 4F R 4F R 2F R 2F 2R 2F R 4F 2R 4F R 2F R 4F L 2F 2R 2F R 4F R 2F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 4F R 2F 2R 2F L 4F R 2F R 4F 2R 2F R 2F R 2F L 8F 2R 2F R 2F L 2F 2R 2F R 2F R 6F R 2F R 2F 2R 4F R 2F R 2F 2R 4F R 2F R 6F R 2F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 4F R 2F R 6F 2R 4F R 2F R 6F 2R 2F R 2F R 2F 2R 2F L 2F R 4F R 2F R 2F 2R 2F R 2F R 6F L 4F 2R 2F R 2F 2R 2F R 2F R 6F L 2F R 2F R 4F R 4F L 2F R 2F 2R 2F L 2F R 6F R 2F R 4F 2R 4F L 2F L 2F R 4F L 2F R 2F R 2F 2R 2F R 2F R 4F 2R 2F R 2F R 4F 2R 2F R 2F 2R 2F R 2F R 2F L 2F R 6F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 2F 2R 2F L 2F R 2F R 4F R 2F 2R 2F R 4F R 6F R 2F R 4F 2R 4F R 2F R 2F 2R 2F R 2F 2R 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 2F L 2F R 2F R 4F R 2F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F 2R 2F R 2F R 4F L 2F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 4F 2R 4F R 2F R 4F 2R 4F L 6F R 2F R 2F 2R 2F L 2F R 2F R 8F R 2F R 4F 2R 2F R 2F R 2F 2R 4F R 2F 2R 2F L 2F R 2F R 4F 2R 2F R 2F R 4F R 2F 2R 2F L 2F R 2F 2R 2F R 2F R 4F L 2F R 2F R 2F L 2F 2R 2F R 2F R 4F R 2F L 4F R 6F R 2F R 4F 2R 4F R 2F R 4F 2R 2F R 2F R 2F 2R 2F R 2F R 2F 2R 2F L 4F R 2F R 2F 2R 6F R 6F R 2F R 4F 2R 4F L 2F R 4F R 2F R 2F 2R 2F R 2F R 8F 2R 4F R 2F R 4F 2R 2F R 2F R 2F 2R 2F L 2F R 2F R 4F R 6F R 2F 2R 2F R 4F 2R 4F R 2F R 2F 2R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 4F L 6F R 2F R 4F 2R 4F R 2F L 4F R 2F R 6F R 2F 2R 4F 2R 2F R 8F R 2F R 4F 2R 6F R 2F R 2F 2R 4F R 2F R 2F 2R 2F L 2F R 4F R 4F R 2F R 2F 2R 2F R 2F 2R 4F R 2F R 6F R 2F 2R 2F R 2F R 4F 2R 4F R 2F R 6F 2R 6F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F 2R 2F R 2F R 4F 2R 6F R 2F R 4F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F 2R 2F R 2F R 2F L 4F 2R 4F R 2F R 6F 2R 6F R 2F R 8F L 2F R 2F R 2F 2R 2F R 2F 2R 2F R 2F R 2F 2R 2F L 2F R 2F L 2F R 6F R 2F R 4F L 2F R 2F 2R 2F L 2F R 4F R 2F R 2F 2R 2F R 2F R 4F 2R 4F L 4F R 2F R 2F 2R 2F L 2F R 2F R 4F R 2F 2R 2F L 2F R 2F R 6F R 2F R 2F L 4F R 2F L 4F R 2F R 2F 2R 2F R 8F R 2F L 4F 2R 4F R 4F R 2F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 6F 2R 4F R 2F R 2F L 2F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 4F R 2F R 6F R 2F 2R 2F R 4F R 2F R 2F 2R 2F R 2F R 2F 2R 4F 2R 2F R 2F R 2F 2R 2F R 2F R 4F 2R 2F R 2F 2R 2F R 12F R 4F R 2F R 2F 2R 2F R 2F R 2F L 4F 2R 4F R 2F R 6F R 2F 2R 2F R 4F 2R 10F R 2F R 8F 2R 2F R 2F R 4F R 2F 2R 2F R 2F R 2F 2R 2F L 2F R 2F R 2F 2R 2F L 2F R 4F L 2F R 6F R 2F R 2F 2R 2F L 2F R 2F R 4F R 6F R 2F 2R 2F R 4F 2R 6F R 2F 2R 2F R 4F L 4F L 2F R 2F R 4F R 2F 2R 4F R 2F R 2F 2R 2F L 2F R 4F R 4F R 2F R 2F 2R 2F R 2F 2R 4F R 2F R 2F 2R 4F R 2F R 4F 2R 4F R 4F R 2F R 2F 2R 2F R 2F R 2F 2R 2F R 2F R 6F 2R 4F R 2F R 6F 2R 4F R 2F R 6F 2R 4F R 2F R 4F 2R 2F R 2F R 4F R 2F 2R 2F L 2F R 2F R 6F L 2F R 6F R 2F R 2F 2R 6F 2R 4F R 2F R 4F 2R 12F R F", path.getFactorizedForm());
    }
}
