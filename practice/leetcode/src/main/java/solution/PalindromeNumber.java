package solution;

/**
 * 9. Palindrome Number (<a href="https://leetcode.com/problems/palindrome-number/description/">...</a>):
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore, it is not a palindrome.
 * <p>
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 */

public class PalindromeNumber {

   public static void main(String[] args) {
      System.out.println(isPalindrome1(10));
      System.out.println(isPalindrome2(10));
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 40 ns
   // Data input: x * 2 -> performance: 60 ns
   public static boolean isPalindrome1(int x) {
      String a = String.valueOf(x);
      int length = a.length();
      for (int i = 0; i < length / 2; i++) {
         if (a.charAt(i) != a.charAt(length - i - 1)) return false;
      }
      return true;
   }

   // Time complexity:  O(n)
   // Space complexity: O(1)
   // Data input: x ->     performance: 140 ns
   // Data input: x * 2 -> performance: 180 ns
   public static boolean isPalindrome2(int x) {
      return new StringBuilder(String.valueOf(x))
          .reverse()
          .toString()
          .equals(String.valueOf(x));
   }
}
