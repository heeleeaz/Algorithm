import java.util.*;

public class BloombergRemoveIndexes {
    public static void main(String[] args) {
        int[] arr = new int[]{-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76};
        int[][] ranges = new int[][]{{5, 8}, {10, 13}, {3, 6}, {20, 25}};

//        System.out.println(removeIndexes(arr, ranges));


        int[] arr2 = new int[]{-8, 3, -5, 1, 51, 56};
        int[][] ranges2 = new int[][]{{0, 2}, {1, 2}};

        System.out.println(removeIndexes(arr2, ranges2));

    }

    public static List<Integer> removeIndexes(int[] arr, int[][] ranges) {
        int length = arr.length;
        int[] lookupArray = new int[length];

        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];

            if (start < length) {
                lookupArray[start]++;
            }
            if (end < length) {
                lookupArray[end]--;
            }
        }

        int sum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sum += lookupArray[i];

            if (sum == 0) {
                result.add(arr[i]);
            }
        }

        return result;

    }
}