public class ProdFib { // must be public for codewars	

    public static long[] productFib(long prod) {
        int previous = 0;
        int current = 1;

        int currentProduct = 0;
        while (currentProduct < prod) {
            int next = previous + current;
            previous = current;
            current = next;

            currentProduct = previous * current;
        }

        System.out.println(previous);
        System.out.println(current);
        return new long[]{previous, current, prod == currentProduct ? 1 : 0};
    }
}