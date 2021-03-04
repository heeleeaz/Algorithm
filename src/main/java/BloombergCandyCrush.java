import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/candy-crush/
public class BloombergCandyCrush {
    Set<int[]> hashSet;

    public int[][] candyCrush(int[][] board) {
        hashSet = new HashSet<>();
        int rLen = board.length;
        int cLen = board[0].length;

        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                int value = board[r][c];
                if (value == 0) continue;

                if (r + 2 < rLen && value == board[r + 1][c] && value == board[r + 2][c]) {
                    hashSet.add(new int[]{r, c});
                    hashSet.add(new int[]{r + 1, c});
                    hashSet.add(new int[]{r + 2, c});
                }

                if (c + 2 < cLen && value == board[r][c + 1] && value == board[r][c + 2]) {
                    hashSet.add(new int[]{r, c});
                    hashSet.add(new int[]{r, c + 1});
                    hashSet.add(new int[]{r, c + 2});
                }
            }
        }

        if (hashSet.isEmpty()) {
            return board;
        }

        for (int[] coordinate : hashSet)
            board[coordinate[0]][coordinate[1]] = 0;

        dropCandies(board);

        return candyCrush(board);
    }

    private void dropCandies(int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            int zeroPointer = board.length - 1;
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    board[zeroPointer--][i] = board[j][i];
                    if (zeroPointer + 1 != j) board[j][i] = 0;
                }
            }
        }
    }
}
