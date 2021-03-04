import java.util.List;

public class ArrayIndexEquality {
    public int indexEqualsValueSearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            System.out.println(mid);

            if (arr[mid] == mid) return mid;

            if (mid < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
