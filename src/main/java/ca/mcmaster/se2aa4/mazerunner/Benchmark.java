package ca.mcmaster.se2aa4.mazerunner;

import java.text.NumberFormat;

public class Benchmark {
    private String filePath;
    private String method;
    private String baseline;

    Benchmark(String filePath, String method, String baseline) {
        this.filePath = filePath;
        this.method = method;
        this.baseline = baseline;
    }

    public void run() throws Exception {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        
        System.out.print("Time Spent Loading Maze from File: ");
        
        long time1 = System.currentTimeMillis();

        MazeExporter exporter = new Maze2DArrayListExporter();
        Maze maze = exporter.createMaze(filePath);

        long time2 = System.currentTimeMillis();

        long totalTime = time2 - time1;

        System.out.println(nf.format(totalTime) + " milliseconds");

        System.out.println();

        System.out.print("Time Spent Exploring Maze with Provided Method: ");

        time1 = System.currentTimeMillis();

        Path pathMethod = solveMaze(method, maze);

        time2 = System.currentTimeMillis();

        totalTime = time2 - time1;

        System.out.println(nf.format(totalTime) + " milliseconds");

        System.out.println();

        System.out.print("Time Spent Exploring Maze with Provided Baseline: ");

        time1 = System.currentTimeMillis();

        Path pathBaseline = solveMaze(baseline, maze);

        time2 = System.currentTimeMillis();

        totalTime = time2 - time1;

        System.out.println(nf.format(totalTime) + " milliseconds");

        System.out.println();

        System.out.print("Speedup: ");

        String pathMethodString = pathMethod.getCanonicalForm();
        pathMethodString = pathMethodString.replaceAll("\\s+", "");

        String pathBaselineString = pathBaseline.getCanonicalForm();
        pathBaselineString = pathBaselineString.replaceAll("\\s+", "");

        double speedup = pathBaselineString.length() / pathMethodString.length();
        
        System.out.println(nf.format(speedup));
    }

    private Path solveMaze(String method, Maze maze) throws Exception {
        MazeSolver solver = null;
        switch (method) {
            case "righthand" -> {
                solver = new RightHandSolver();
            }
            case "tremaux" -> {
                solver = new TremauxSolver();
            }
            case "bfs" -> {
                solver = new BFSSolver();
            }
            default -> {
                throw new Exception("Maze solving method '" + method + "' not supported.");
            }
        }
        
        return solver.solve(maze);
    }
}
