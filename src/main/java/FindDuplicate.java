import java.util.HashSet;
import java.util.Set;

class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> count = new HashSet<>(nums.length);

        for (int num : nums) {
            if (count.contains(num)) {
                return num;
            }
            count.add(num);
        }
        return -1;
    }
}