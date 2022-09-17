package collection.stack;

public class StackTest {
   public static void main(String[] args) {
      testStack();
   }

   private static void testStack() {
      SimpleStack<Integer> stack = new SimpleStack<>();
      for (int i = 1; i < 10; i++) {
         stack.push(i);
         System.out.println(i);
      }
      System.out.println("\n");
      while (!stack.isEmpty()) System.out.println(stack.pop());
   }
}
