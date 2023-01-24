package solution;

import java.util.*;

/**
 * 1. Two Sum (<a href="https://leetcode.com/problems/two-sum/">...</a>):
 * <p>
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

public class TwoSum {
   public static void main(String[] args) {
      int[] nums = {2, 7, 11, 15};

      int[] res1 = twoSum1(nums, 9);
      System.out.println(Arrays.toString(res1));

      int[] res2 = twoSum2(nums, 9);
      System.out.println(Arrays.toString(res2));
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 40  ns
   // Data input: x * 2 -> performance: 80  ns
   // Data input: x * 4 -> performance: 200 ns
   public static int[] twoSum1(int[] nums, int target) {
      int[] res = new int[2];
      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
               res[0] = i;
               res[1] = j;
               return res;
            }
         }
      }
      return res;
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 200 ns
   // Data input: x * 2 -> performance: 300 ns
   // Data input: x * 4 -> performance: 700 ns
   public static int[] twoSum2(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         int complement = target - nums[i];
         if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
         }
         map.put(nums[i], i);
      }
      return new int[]{-1, -1};
   }
}
