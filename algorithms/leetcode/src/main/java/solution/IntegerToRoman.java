package solution;

/**
 * 12. Integer to Roman (<a href="https://leetcode.com/problems/integer-to-roman/">...</a>):
 * <p>
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Example 1:
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * <p>
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 3:
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class IntegerToRoman {
   public static void main(String[] args) {
      System.out.println(intToRoman1(1994));
      System.out.println(intToRoman2(1994));
   }

   static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
   static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

   // Time complexity:  O(1)
   // Space complexity: O(1)
   // Data input: x ->     performance: 200 ns
   public static String intToRoman1(int num) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < values.length; i++) {
         while (num >= values[i]) {
            sb.append(symbols[i]);
            num -= values[i];
         }
      }

      return sb.toString();
   }

   // Time complexity:  O(1)
   // Space complexity: O(1)
   // Data input: x ->     performance: 100 ns
   public static String intToRoman2(int num) {
      StringBuilder st = new StringBuilder("");
      int i = 0;
      while (num > 0) {
         if (num >= values[i]) {
            st.append(symbols[i]);
            num -= values[i];
         } else {
            i++;
         }
      }
      return st.toString();
   }
}
