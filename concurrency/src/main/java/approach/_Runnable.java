package approach;

public class _Runnable implements Runnable {

   private final String name;

   public _Runnable(String name) {
      this.name = name;
   }

   @Override
   public void run() {
      System.out.println("run() " + name + " running");
   }

   public static void main(String[] args) {
      Thread thread1 = new Thread(new _Runnable("1"));
      Thread thread2 = new Thread(new _Runnable("2"));
      Thread thread3 = new Thread(new _Runnable("3"));
      Thread thread4 = new Thread(new _Runnable("4"));
      Thread thread5 = new Thread(new _Runnable("5"));
      Thread thread6 = new Thread(new _Runnable("6"));
      Thread thread7 = new Thread(new _Runnable("7"));
      thread7.setPriority(Thread.MAX_PRIORITY);
      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
      thread5.start();
      thread6.start();
      thread7.start();
   }
}
