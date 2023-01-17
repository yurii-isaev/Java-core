package multithreading.approach;

public class JoinExample extends Thread {

   public JoinExample(String name) {
      super(name);
   }

   @Override
   public void run() {
      String currentThreadName = Thread.currentThread().getName();
      for (int i = 0; i < 10; i++) {
         System.out.println(currentThreadName + " is running " + i);
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
      System.out.println(currentThreadName + " completed");
   }

   public static void main(String[] args) throws InterruptedException {
      JoinExample a = new JoinExample("A");
      JoinExample b = new JoinExample("B");
      JoinExample c = new JoinExample("C");

      a.start();
      a.join(); // ожидает завершение потока a

      b.start();
      b.join(); // ожидает завершение потока b

      c.start();
   }
}
