package behavioral.strategy.cl;

/**
 * Client - context
 */

public class Switcher {
   private Strategy strategy;

   public void setStrategy(Strategy strategy) {
      this.strategy = strategy;
   }

   public void executeStrategy() {
      strategy.operation();
   }
}
