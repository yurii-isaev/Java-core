package concurrency;

public class _Join extends Thread {

   public _Join(String name) {
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
      _Join a = new _Join("A");
      _Join b = new _Join("B");
      _Join c = new _Join("C");

      a.start();
      a.join(); // ожидает завершение потока a

      b.start();
      b.join(); // ожидает завершение потока b

      c.start();
   }
}
