class IsPerfectSquareDouble {
    public static void main(String[] args) {
        System.out.println(root(9, 2));

    }

    public static double root(double x, int n) {
        double left = n, right = x / n;
        double pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            double guessedRoot = pivot * pivot;
            if (Math.abs(guessedRoot - x) == 0.0) {
                return guessedRoot;
            } else if (x < guessedRoot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return right;
    }
}