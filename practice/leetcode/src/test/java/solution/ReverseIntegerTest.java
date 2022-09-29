package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {

   @Test
   public void test_ReverseInteger1() {
      ReverseInteger ri = new ReverseInteger();
      int input = 123;
      int output = 321;
      assertEquals(output, ri.reverse1(input));

      input = -123;
      output = -321;
      assertEquals(output, ri.reverse1(input));

      input = 120;
      output = 21;
      assertEquals(output, ri.reverse1(input));
   }

   @Test
   public void test_ReverseInteger2() {
      ReverseInteger ri = new ReverseInteger();
      int input = 123;
      int output = 321;
      assertEquals(output, ri.reverse2(input));

      input = -123;
      output = -321;
      assertEquals(output, ri.reverse2(input));

      input = 120;
      output = 21;
      assertEquals(output, ri.reverse2(input));
   }
}
