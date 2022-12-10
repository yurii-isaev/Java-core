package behavioral.interpreter;

import java.util.Map;

// Terminal Expression
class NumberExpression implements Expression {
   private int number;

   public NumberExpression(int number) {
      this.number = number;
   }

   public int interpret(Map<String, Integer> variables) {
      return number;
   }
}
