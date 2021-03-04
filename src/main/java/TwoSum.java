import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int complement = target - number;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(number, i);
        }
        return null;
    }

    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[]{i, hash.get(target - nums[i])};
            }

            hash.put(nums[i], i);
        }

        return null;
    }
}
