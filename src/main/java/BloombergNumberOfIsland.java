import java.util.LinkedList;
import java.util.Queue;

public class BloombergNumberOfIsland {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numberOfIsland = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ++numberOfIsland;
                    dfs(grid, r, c);
                }
            }
        }

        return numberOfIsland;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numberOfIsland = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ++numberOfIsland;

                    grid[r][c] = '0';
                    Queue<int[]> neighbour = new LinkedList<>();
                    neighbour.offer(new int[]{r, c});

                    while (!neighbour.isEmpty()) {
                        int[] rc = neighbour.poll();
                        int row = rc[0];
                        int col = rc[1];

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbour.offer(new int[]{row - 1, col});
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            neighbour.offer(new int[]{row + 1, col});
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbour.offer(new int[]{row, col - 1});
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
                            neighbour.offer(new int[]{row, col + 1});
                            grid[row][col + 1] = '0';
                        }

                    }
                }
            }
        }

        return numberOfIsland;
    }
}
