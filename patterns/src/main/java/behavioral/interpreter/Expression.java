package behavioral.interpreter;

import java.util.Map;

// Abstract Expression
interface Expression {
   int interpret(Map<String, Integer> variables);
}
