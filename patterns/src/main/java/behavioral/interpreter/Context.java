package behavioral.interpreter;

import java.util.Map;

// Context
class Context {
   private Expression expression;

   public Context(Expression expression) {
      this.expression = expression;
   }

   public int interpret(Map<String, Integer> variables) {
      return expression.interpret(variables);
   }
}
