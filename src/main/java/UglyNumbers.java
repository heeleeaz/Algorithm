public class UglyNumbers {
    public int uglyNumbers(int n) {
        int[] memo = new int[n + 1];
        return run(memo, n);
    }

    private int run(int[] memo, int n) {
        if (n == 3 || n == 5 || n == 2) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = run(memo, n - 2) + run(memo, n - 3) + run(memo, n - 5);
        return memo[n];
    }
}
