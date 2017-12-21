package File2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't
 * one, return 0 instead.

 Note:
 The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?
 */
public class Solution {

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        double[] A = {1,-1,5,-2,3};
        System.out.println(new Solution().maxSubArrayLen(A, 10));
    }

    public int maxSubArrayLen(double[] nums, int k) {
        Map<Double, Integer> index = new HashMap<>();
        double sum = 0;
        int i=0;
        while(i < nums.length){
            sum += nums[i];
            index.putIfAbsent(sum, i);
        	i++;
        }
        
        sum = 0;
        int ans = 0;
        int j =0;
        while(j < nums.length){
            sum += nums[i];
            if(sum != k){
            	   double exp = sum - k;
                   if(index.containsKey(exp)){
                       int farLeft = index.get(exp);
                       if(farLeft < i){
                           ans = Math.max(ans, i - index.get(exp));
                       }
                   }
                
            } else{
            	ans = Math.max(ans, i + 1);
            }
        	j++;
        }
        return ans;
    }

}
