# Assignment A3 - Maze Runner, Take Two

* **Student**: [Cheukman Zhou](zhouc98@mcmaster.ca)
* **Program**: B. Eng. In Software Engineering
* **Course code**: SFWRENG 2AA4
* **Course Title**: Software Design I - Introduction to Software Development
* Term: *Level II - Winter 2024*
* **Author of Original Code**: Alexandre Lachance

## Business Logic Specification

This program explores a maze, finding a path from an entry point to an exit one.

- The maze is stored in a text file, with `#` representing walls and `␣` (_empty space_) representing passages.
- You’ll find examples of such mazes in the [`examples`](./examples) directory.
    - You can also use the [Maze Generator](https://github.com/ace-lectures/maze-gen) to generate others.
- The Maze is surrounded by walls on its four borders, except for its entry/exit points.
    - Entry and exit points are always located on the East and West border.
    - The maze is not directed. As such, exit and entry can be interchanged.
- At the beginning of the exploration, we're located on the entry tile, facing the opposite side (e.g., if entering by
  the eastern entry, you're facing West).
- The program generates a sequence of instructions to reach the opposite exit (i.e., a "path"):
    - `F` means 'move forward' according to your current direction
    - `R` means 'turn right' (does not move, just change direction), and `L` means ‘turn left’.
- A canonical path contains only `F`, `R` and `L` symbols
- A factorized path squashes together similar instructions (i.e., `FFF` = `3F`, `LL` = `2L`).
- Spaces are ignored in the instruction sequence (only for readability: `FFLFF` = `FF L FF`)
- The program takes as input a maze and print the path on the standard output.
- The program can take a path as input and verify if it's a legit one.
- The program can benchmark between two given algorithms: one being the baseline algorithm and the other being the method you want to solve the maze by. 

## How to run this software?

To build the program, simply package it with Maven:

```
mosser@azrael A3-Template % mvn -q clean package 
```

### Delivered version

#### Command line arguments

The delivered program at the end of this assignment should use the following flags:

- `-i MAZE_FILE`: specifies the filename to be used;
- `-p PATH_SEQUENCE`: activates the path verification mode to validate that PATH_SEQUENCE is correct for the maze
- `-method {tremaux, righthand, bfs}`: specifies which path computation method to use. (default is right hand)
- `-baseline {tremaux, righthand, bfs}`: specifies which path computation method to use in benchmark mode. (default is right hand)

#### Examples

When no logs are activated, the programs only print the computed path on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt
4F
mosser@azrael A3-Template %
```

If a given path is correct, the program prints the message `correct path` on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 4F
correct path
mosser@azrael A3-Template %
```

If a given path is incorrect, the program prints the message `incorrect path` on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 3F
inccorrect path
mosser@azrael A3-Template %
```

If a method is given, the program would print the computed path using that algorithm on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -method bfs
4F
mosser@azrael A3-Template %
```

If a baseline algorithm is given, it would run in benchmark mode and would use the `-method` entered as the method algorithm (default is right hand) and the `-baseline` as the baseline algorithm. It would print the time spent loading the maze from file in milliseconds, time spent exploring the maze using the method algorithm in milliseconds, the time spent exploring the maze using the baseline algorithm in milliseconds, and the speedup between the two algorithms.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/huge.maz.txt -method bfs -baseline righthand
Time Spent Loading Maze from File: 2 milliseconds

Time Spent Exploring Maze with Provided Method: 34 milliseconds

Time Spent Exploring Maze with Provided Baseline: 285 milliseconds

Speedup: 35
mosser@azrael A3-Template %
```