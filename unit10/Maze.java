package unit10;


import java.util.Arrays;
import java.util.stream.Collectors;


public class Maze {
    private boolean solution;
    private char[][] maze;


    /**
     * Instantiates a Maze instance based on the provided arguments
     *
     * @param rows the number of rows
     * @param cols the number of columns
     * @param line the values to be placed in the maze.
     */
    public Maze(int rows, int cols, String line) {
        maze = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = line.charAt(index);
                index++;
            }
        }
    }


    /**
     * @return the starting coordinates as "r c"
     */
    public String getStart() {
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }


    /**
     * @return the ending coordinates as "r c"
     */
    public String getEnd() {
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }


    /**
     * Uses recursion to see if the maze has a solution or not.
     *
     * Suggested algorithm:
     * if R and C are in bounds and spot is !#
     * - if you are at $:
     * - - set has a solution
     * - else:
     * - - mark spot as checked
     * - - recur up
     * - - recur down
     * - - recur left
     * - - recur right
     *
     * @param r current row index
     * @param c current column index
     */
    private void check(int r, int c) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || maze[r][c] == '#') {
            return;
        }


        if (maze[r][c] == '$') {
            solution = true;
            return;
        }


        maze[r][c] = '#'; // Mark the spot as checked


        check(r - 1, c); // Recur up
        check(r + 1, c); // Recur down
        check(r, c - 1); // Recur left
        check(r, c + 1); // Recur right
    }


    /**
     * Determines if there is a solution (a path of '.') for this maze.
     *
     * @return true if the maze has a path from Start (@) to End ($).
     */
    public boolean hasSolution() {
        solution = false; // Initialize solution flag
        String start = getStart();
        String[] coordinates = start.split(" ");
        int startRow = Integer.parseInt(coordinates[0]);
        int startCol = Integer.parseInt(coordinates[1]);
        check(startRow, startCol); // Start recursive checking
        return solution;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : maze) {
            sb.append(row).append("\n");
        }
        return sb.toString();
    }


    public static boolean check(boolean test) {return test;}


    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());


        Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
        check(case1.hasSolution());


        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());


        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());


        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());


        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());


        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());


        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());


        System.out.println("Happy Panda! \uD83D\uDC3C");


    }


}



