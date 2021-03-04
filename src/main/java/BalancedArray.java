import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//GS

public class BalancedArray {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>(4);
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(6);
        System.out.println(balancedSum(items));

        List<List<Integer>> store = new ArrayList();

        store.add(List.of(10, 11));

    }

//    static int pivotIndex(int[] nums) {
//        int arraySum = 0;
//        int leftSum = 0;
//
//        for (int item : nums) arraySum += item;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (leftsum == sum - leftsum - nums[i]) return i;
//            leftsum += nums[i];
//        }
//        return -1;
//    }

    public static int balancedSum(List<Integer> arr) {
        int arraySum = 0;
        int leftSum = 0;

        for (int item : arr)
            arraySum += item;

        for (int i = 0; i < arr.size(); i++) {
            int rightSum = arraySum - (leftSum + arr.get(i));
            if (leftSum == rightSum)
                return i;

            leftSum += arr.get(i);
        }

        return -1;
    }

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Set<Integer> hash = new HashSet();

        List<List<Integer>> store = new ArrayList();

        for(int i=0; i<arr.length; i++){
            int a = arr[i];

            int x = a - k;

            if(hash.contains(x)){
                hash.remove(x);

                store.add(List.of(a, x));
            }else{
                hash.add(x);
            }
        }

        return store.toArray(new int[store.size()][store.get(0).size()]);
    }
}
