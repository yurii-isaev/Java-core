package solution;

/**
 * 7. Reverse Integer (<a href="https://leetcode.com/problems/reverse-integer/description/">...</a>):
 * <p>
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 */

public class ReverseInteger {
   public static void main(String[] args) {
      System.out.println(reverse1(123));
      System.out.println(reverse2(123));
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 25 ns
   // Data input: x * 2 -> performance: 50 ns
   public static int reverse1(int x) {
      long result = 0;
      while (x != 0) {
         result = result * 10 + x % 10;
         x /= 10;
      }
      if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
         return 0;
      }
      return (int) result;
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 140 ns
   // Data input: x * 2 -> performance: 200 ns
   public static int reverse2(int x) {
      boolean isNegative = x < 0;
      String numStr = String.valueOf(Math.abs(x));
      StringBuilder reversedStr = new StringBuilder(numStr);
      reversedStr.reverse();
      try {
         int rev = Integer.parseInt(reversedStr.toString());
         return isNegative ? -rev : rev;
      } catch (NumberFormatException e) {
         return 0;
      }
   }
}
