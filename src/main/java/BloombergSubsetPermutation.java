import java.util.ArrayList;
import java.util.List;

public class BloombergSubsetPermutation {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outputs = new ArrayList<>();
        outputs.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : outputs) {
                List<Integer> s = new ArrayList<>(curr);
                s.add(num);
                newSubsets.add(s);
            }

            outputs.addAll(newSubsets);
        }

        return outputs;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(0, i, new ArrayList<>(), subset, nums);
        }

        return subset;
    }

    public void backtrack(int start, int k, List<Integer> current, List<List<Integer>> subsets, int[] nums) {
        if (current.size() == k) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, k, current, subsets, nums);
            current.remove(current.size() - 1);
        }

    }
}
