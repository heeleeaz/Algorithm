public class FixedPointInArray {
    public int fixedPoint(int[] arr) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int pivot = l + (h - l) / 2;

            if (arr[pivot] == pivot) {
                return pivot;
            } else if (arr[pivot] < pivot) {
                l = pivot + 1;
            } else {
                h = pivot - 1;
            }
        }

        return -1;
    }
}
