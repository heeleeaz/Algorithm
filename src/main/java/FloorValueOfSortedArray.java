public class FloorValueOfSortedArray {
    public int floorValue(int[] arr, int k) {
        int l = 0, h = arr.length - 1;

        int minValue = Integer.MIN_VALUE;
        while (l <= h) {
            int pivot = l + ((h - l) / 2);

            if (arr[pivot] < k && arr[pivot] > minValue) {
                minValue = arr[pivot];
                l = pivot + 1;
            } else {
                h = pivot - 1;
            }
        }

        return minValue;
    }
}
