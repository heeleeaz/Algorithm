import java.util.Arrays;

class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int maxSum = -1;
        
        int l = 0, h = nums.length - 1;
        
        while(l < h){
            int sum = nums[l] + nums[h];
            if(sum < k){
                maxSum = Math.max(maxSum, sum);
                l++;
            }else{
                h--;
            }
        }
        
        return maxSum;
        
    }
}