import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
//        System.out.println(fibonacciDynamicProgramming(5));
    }

    private static List<Integer> fibonacciIterative(int n) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);

        for (int i = 2; i < n; i++) {
            int lastNumber = sequence.get(sequence.size() - 1);
            int secondToLastNumber = sequence.get(sequence.size() - 2);

            sequence.add(lastNumber + secondToLastNumber);
        }

        return sequence;

    }

    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int previousNumber = 0;
        int currentNumber = 1;
        for (int i = 2; i <= n; i++) {
            int sum = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = sum;
        }

        return currentNumber;

    }

    private static int fibonacciRecursion(int n) {
        if (n <= 1) return n;

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciDynamicProgramming(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
