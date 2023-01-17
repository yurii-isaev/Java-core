package multithreading.approach;

public class RunnableExample implements Runnable {

   private final String name;

   public RunnableExample(String name) {
      this.name = name;
   }

   @Override
   public void run() {
      System.out.println("run() " + name + " running");
   }

   public static void main(String[] args) {
      Thread thread1 = new Thread(new RunnableExample("1"));
      Thread thread2 = new Thread(new RunnableExample("2"));
      Thread thread3 = new Thread(new RunnableExample("3"));
      Thread thread4 = new Thread(new RunnableExample("4"));
      Thread thread5 = new Thread(new RunnableExample("5"));
      Thread thread6 = new Thread(new RunnableExample("6"));
      Thread thread7 = new Thread(new RunnableExample("7"));
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
