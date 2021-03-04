class ClimbStairs {
    public int climbStairs(int n) {
        return helper(n, 0, new int[n + 1]);
    }

    public int helper(int n, int step, int[] memo) {
        if (step > n) {
            return 0;
        }

        if (step == n) {
            return 1;
        }

        if (memo[step] > 0) {
            return memo[step];
        }

        return memo[step] = helper(n, step + 1, memo) + helper(n, step + 2, memo);
    }
}