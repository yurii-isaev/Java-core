package behavioral.strategy.en;

public class Main {
   public static void main(String[] args) {
      Switcher client = new Switcher();
      client.setStrategy(Strategy.LAMP); // установление реализации
      client.executeStrategy();          // выполнение реализации
   }
}
