public class NegativeNumberInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        int rIdx = nRows - 1;
        int cIdx = 0;
        int count = 0;
        while(rIdx >= 0 && cIdx < nCols){
            if(grid[rIdx][cIdx] < 0){
                count += nCols - cIdx;
                --rIdx;
            }else{
                ++cIdx;
            }
        }

        return count;

//        int M = grid.length, N = grid[0].length;
//        int row = M-1, col = 0;
//        int neg_count = 0;
//
//        while(row >= 0 && col < N) {
//            // if the current is neg, all its left are neg as well
//            // We check if the same can be said about its upper element in above row
//            if(grid[row][col] < 0) {
//                neg_count += N - col;
//                --row;
//            }
//            else
//                ++col;
//        }
//        return neg_count;

    }
}

//iterate out array
//iterate inner aray