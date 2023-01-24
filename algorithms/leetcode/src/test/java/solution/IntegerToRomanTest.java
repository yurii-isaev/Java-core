package solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanTest {

   @Test
   public void test_IntegerToRoman1() {
      assertEquals("III", IntegerToRoman.intToRoman1(3));
      assertEquals("IV", IntegerToRoman.intToRoman1(4));
      assertEquals("IX", IntegerToRoman.intToRoman1(9));
      assertEquals("LVIII", IntegerToRoman.intToRoman1(58));
      assertEquals("MCMXCIV", IntegerToRoman.intToRoman1(1994));
   }

   @Test
   public void test_IntegerToRoman2() {
      assertEquals("III", IntegerToRoman.intToRoman2(3));
      assertEquals("IV", IntegerToRoman.intToRoman2(4));
      assertEquals("IX", IntegerToRoman.intToRoman2(9));
      assertEquals("LVIII", IntegerToRoman.intToRoman2(58));
      assertEquals("MCMXCIV", IntegerToRoman.intToRoman2(1994));
   }
}
