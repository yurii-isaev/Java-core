package solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumberTest {

   @Test
   public void test_IsPalindrome1() {
      assertTrue(PalindromeNumber.isPalindrome1(121));
      assertFalse(PalindromeNumber.isPalindrome1(-121));
      assertFalse(PalindromeNumber.isPalindrome1(10));
   }

   @Test
   public void test_IsPalindrome2() {
      assertTrue(PalindromeNumber.isPalindrome2(121));
      assertFalse(PalindromeNumber.isPalindrome2(-121));
      assertFalse(PalindromeNumber.isPalindrome2(10));
   }
}
