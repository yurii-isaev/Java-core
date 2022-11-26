package behavioral.strategy.en;

public enum Strategy {

   LAMP {
      @Override
      public void operation() {
         System.out.println("Lamp light on");
      }
   },

   RADIO {
      @Override
      public void operation() {
         System.out.println("Radio plays");
      }
   };

   public abstract void operation();
}
