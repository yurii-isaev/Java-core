package task;

public class Counter2 {
   private int count;

   private synchronized void increment1() {
      // synchronized (this) { // new Object();
         count++;
      //}
   }

   private synchronized void increment2() {
      // synchronized (this) { // new Object();
         count++;
      //}
   }

   private void counter() {
      Thread thread1 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
            increment1();
            increment2();
         }
         System.out.printf("increment1 = %d thread1 \n", count);
         System.out.printf("increment2 = %d thread1 \n", count);
      });

      Thread thread2 = new Thread(() -> {
         for (int i = 0; i < 100000; i++) {
            increment1();
            increment2();
         }
         System.out.printf("increment1 = %d thread2 \n", count);
         System.out.printf("increment2 = %d thread2 \n", count);
      });

      thread1.start();
      thread2.start();
      //increment1 = 360171 thread1
      //increment2 = 400000 thread1
      //increment1 = 400000 thread2
      //increment2 = 400000 thread2
   }

   public static void main(String[] args) {
      new Counter2().counter();
   }
}
