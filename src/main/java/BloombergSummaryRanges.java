import java.util.ArrayList;
import java.util.List;

//Input: arr[] = {1, 2, 3, 6, 7}
//        Output: 1->3, 6->7
public class BloombergSummaryRanges {
    public static void main(String[] args) {
//        System.out.println(summaryRanges(new int[]{1, 2, 3, 6, 7}));
//        System.out.println(summaryRanges(new int[]{-1, 0, 1, 2, 5, 6, 8}));
        System.out.println(summaryRanges2(new int[]{-1, 0, 1, 2, 5, 6, 8}));
    }

    public static String summaryRanges(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        stringBuilder.append("->");

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current - prev > 1) {
                stringBuilder.append(prev);
                stringBuilder.append(", ");
                stringBuilder.append(current);
                stringBuilder.append("->");
            }

            prev = current;
        }

        System.out.println(prev);
        stringBuilder.append(nums[nums.length - 1]);

        return stringBuilder.toString();
    }

    public static List<String> summaryRanges2(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<String> rangeSummary = new ArrayList<>();
        int rangeStart = nums[0];
        int numLength = nums.length;
        for (int i = 1; i <= numLength; i++) {
            if (i == numLength || nums[i] - nums[i - 1] != 1) {
                String range = getRange(rangeStart, nums[i - 1]);
                rangeSummary.add(range);
                if (i < numLength) rangeStart = nums[i];
            }
        }
        return rangeSummary;
    }

    private static String getRange(int rangeStart, int rangeEnd) {
        if (rangeStart == rangeEnd) {
            return String.valueOf(rangeStart);
        }
        return String.format("%d->%d", rangeStart, rangeEnd);
    }
}
