package behavioral.interpreter;

import java.util.Map;

// Non-terminal Expression
class VariableExpression implements Expression {
   private String variableName;

   public VariableExpression(String variableName) {
      this.variableName = variableName;
   }

   public int interpret(Map<String, Integer> variables) {
      if (variables.containsKey(variableName)) {
         return variables.get(variableName);
      }
      return 0;
   }
}
