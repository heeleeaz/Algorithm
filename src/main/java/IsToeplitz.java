class IsToeplitz {

    static boolean isToeplitz(int[][] arr) {
        boolean[][] isVisited = new boolean[arr.length][arr[0].length];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (!isVisited[r][c]) {
                    System.out.println("New");
                    if (!bfs(arr, r, c, arr[r][c], isVisited)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private static boolean bfs(int[][] arr, int r, int c, int value, boolean[][] isVisited) {
        if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length) {

            isVisited[r][c] = true;
            if (arr[r][c] == value) {
                bfs(arr, r + 1, c + 1, value, isVisited);
                return true;
            } else {
                System.out.println("not Value");
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isToeplitz(new int[][]
                {
                        {3, 1, 7},
                        {4, 1, 1},
                        {2, 4, 3}
                });
    }
}