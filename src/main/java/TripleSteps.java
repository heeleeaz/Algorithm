public class TripleSteps {
    public static void main(String[] args) {
        System.out.println(tripleSteps(1));
    }

    public static int tripleSteps(int n) {
        if (n < 3) return n;

        int[] steps = new int[n + 1];

        steps[0] = 1;
        steps[1] = 2;
        steps[3] = 3;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }

        return steps[n - 1];
    }
}
