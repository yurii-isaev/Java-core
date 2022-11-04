package concurrency.threadpool;

public class DeadLock {
   static class Friend {

      private final String name;

      public Friend(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }

      public synchronized void bow(Friend bower) { // Gastone
         System.out.format("%s has bowed to %s %n", bower.getName(), this.name);
         bower.bowBack(this);
      }

      private synchronized void bowBack(Friend bower) { // Alphonse
         System.out.format("%s has bowed back to %s %n", bower.getName(), this.name);
      }
   }

   public static void main(String[] args) {
      final Friend alphonse = new Friend("Alphonse");
      final Friend gastone = new Friend("Gastone");

      new Thread(() -> {
         System.out.println("Thread 1");
         alphonse.bow(gastone);
         System.out.println("Thread 1 completed");
      }).start();

      new Thread(() -> {
         System.out.println("Thread 2");
         gastone.bow(alphonse);
         System.out.println("Thread 2 completed");
      }).start();

      //Thread 1
      //Gastone has bowed to Alphonse
      //Thread 2
      //Alphonse has bowed to Gastone
   }
}
