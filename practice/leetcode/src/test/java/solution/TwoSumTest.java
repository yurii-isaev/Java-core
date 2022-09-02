package solution;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

   @Test
   public void test_TwoSum1() {
      int[] nums = {2, 7, 11, 15};
      int target = 9;
      int[] expected = {0, 1};
      int[] result = TwoSum.twoSum1(nums, target);
      assertArrayEquals(expected, result);

      int[] nums2 = {3, 2, 4};
      int target2 = 6;
      int[] expected2 = {1, 2};
      int[] result2 = TwoSum.twoSum1(nums2, target2);
      assertArrayEquals(expected2, result2);

      int[] nums3 = {3, 3};
      int target3 = 6;
      int[] expected3 = {0, 1};
      int[] result3 = TwoSum.twoSum1(nums3, target3);
      assertArrayEquals(expected3, result3);
   }

   @Test
   public void test_TwoSum2() {
      int[] nums = {2, 7, 11, 15};
      int target = 9;
      int[] expected = {0, 1};
      int[] result = TwoSum.twoSum2(nums, target);
      assertArrayEquals(expected, result);

      int[] nums2 = {3, 2, 4};
      int target2 = 6;
      int[] expected2 = {1, 2};
      int[] result2 = TwoSum.twoSum2(nums2, target2);
      assertArrayEquals(expected2, result2);

      int[] nums3 = {3, 3};
      int target3 = 6;
      int[] expected3 = {0, 1};
      int[] result3 = TwoSum.twoSum2(nums3, target3);
      assertArrayEquals(expected3, result3);
   }
}
