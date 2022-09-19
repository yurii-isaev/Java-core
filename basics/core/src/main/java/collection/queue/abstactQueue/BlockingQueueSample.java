package collection.queue.abstactQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * BlockingQueue - это очередь Queue со следующими дополнениями:
 * Блокирующая операция take() - берет следующий элемент,
 * если же очередь пустая - блокирует выполнение до появления элемента (до момента, когда перестанет быть пустой)
 * Блокирующая операция put(E e) - помещает элемент в очередь,
 * если очередь заполнена - блокирует выполнение до освобождения места в очереди и
 * успешного помещения в нее нового элемента.
 */
public class BlockingQueueSample {
   public static void main(String[] args) {
      ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

      Thread producer = new Thread(() -> {
         String[] words = {"123", "abc", "qwerty", "queue", "stack", "array", "list"};
         for (int i = 0; i < words.length && !Thread.interrupted();) {
            try {
               Thread.sleep(5000);
               queue.put(words[i]);
               System.out.println(
                   "producer: queued up " + words[i] +
                   ", number of elements in the queue: " + queue.size());
               i++;
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread consumer = new Thread(() -> {
         StringBuilder sb = new StringBuilder();
         while (!Thread.interrupted()) {
            try {
               sb.setLength(0);
               Thread.sleep(8000);
               sb.append(queue.take());
               System.out.println(
                   "consumer: processed from the queue " + sb.reverse() +
                   ", number of elements in the queue: " + queue.size());
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      producer.start();
      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      consumer.start();
   }
}
