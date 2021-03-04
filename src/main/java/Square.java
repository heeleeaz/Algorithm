public class Square {
    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) - sqrt == 0;
    }
}