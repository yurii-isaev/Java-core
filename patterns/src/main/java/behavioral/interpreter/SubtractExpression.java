package behavioral.interpreter;

import java.util.Map;

// Non-terminal Expression
class SubtractExpression implements Expression {
   private Expression leftExpression;
   private Expression rightExpression;

   public SubtractExpression(Expression leftExpression, Expression rightExpression) {
      this.leftExpression = leftExpression;
      this.rightExpression = rightExpression;
   }

   public int interpret(Map<String, Integer> variables) {
      return leftExpression.interpret(variables) - rightExpression.interpret(variables);
   }
}
