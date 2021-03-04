class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(8));

    }

    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        int left = 2, right = num / 2;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            long value = (long) pivot * pivot;
            if (value == num) {
                return true;
            } else if (num < value) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return false;
    }
}