class BloombergWordSearch {
    private int NROWS, NCOLS;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.NROWS = board.length;
        this.NCOLS = board[0].length;
        this.board = board;

        for (int r = 0; r < NCOLS; r++) {
            for (int c = 0; c < NCOLS; c++) {
                if (backtrack(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) return true;

        if (row < 0 || row >= NROWS || col < 0 || col >= NCOLS || word.charAt(index) != board[row][col]) return false;

        if(board[row][col] == '#') return false;

        board[row][col] = '#';

        boolean isExists = backtrack(row, col + 1, word, index + 1)
                || backtrack(row + 1, col, word, index + 1)
                || backtrack(row, col - 1, word, index + 1)
                || backtrack(row - 1, col, word, index + 1);

        this.board[row][col] = word.charAt(index);
        return isExists;

    }
}