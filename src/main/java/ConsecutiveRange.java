//import java.util.HashSet;
//import java.util.Set;
//
//public class ConsecutiveRange {
//    public int consecutiveRange(int[] nums) {
//        int left = 0, right = 1;
//        int n = nums.length;
//
//        Set<Integer> set = new HashSet<>();
//        set.add(nums[0]);
//
//        while (left < n && right < n) {
//            int diff = nums[right++] - nums[left++];
//            if (diff == 1) {
//                System.out.println("A");
//            } else {
//                set.add(left);
//                set.add(right);
//            }
//        }
//    }
//}
