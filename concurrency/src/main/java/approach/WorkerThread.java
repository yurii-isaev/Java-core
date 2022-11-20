package approach;

import java.util.*;
import java.util.stream.IntStream;

public class WorkerThread {
   public static void main(String[] args) throws InterruptedException {
      BlockingQueue queue = new BlockingQueue();

      Thread worker = new Thread(() -> {
         try {
            while (!Thread.currentThread().isInterrupted()) {
               Runnable task = queue.get();
               task.run();
            }
         } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
         }
      });
      worker.start();

      IntStream.range(0, 8).forEach(n -> queue.put(getTask()));

      Thread.sleep(15000);

      // Прерывание worker из потока main
      worker.interrupt();
   }

   public static Runnable getTask() {
      return new Runnable() {
         @Override
         public void run() {
            System.out.println("Task started: " + this);
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
            System.out.println("Task finished: " + this);
         }
      };
   }

   static class BlockingQueue {
      List<Runnable> tasks = new ArrayList<>();

      public synchronized Runnable get() throws InterruptedException {
         while (tasks.isEmpty()) {
            wait();
         }
         Runnable task = tasks.get(0);
         tasks.remove(task);
         return task;
      }

      public synchronized void put(Runnable task) {
         tasks.add(task);
         notify();
      }
   }
}
