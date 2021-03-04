public class NumberOfOccurrenceInArray {
    public int numberOfOccurrence(int[] arr, int k) {
        int l = 0, h = arr.length - 1;

        int count = 0;
        while (l < h) {
            int pivot = l + ((h - l) / 2);
            if(pivot == arr.length)
                break;

            if (arr[pivot] == k && arr[pivot] == arr[pivot + 1]) {
                count = +1;
            } else if (arr[pivot] < k) {
                l = pivot + 1;
            } else {
                h = pivot - 1;
            }
        }

        return count + 1;
    }
}
