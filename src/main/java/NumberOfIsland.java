public class NumberOfIsland {
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

//    public static int findCircleNum(int[][] isConnected) {
//        int count = 0;
//
//    }
}
