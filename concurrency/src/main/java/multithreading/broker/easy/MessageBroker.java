package multithreading.broker.easy;

import java.util.*;

public final class MessageBroker {
   private final Queue<Message> messageQueue;
   private final int maxStoredMessages;

   public MessageBroker(int maxMessages) {
      this.messageQueue = new ArrayDeque<>(maxMessages);
      this.maxStoredMessages = maxMessages;
   }

   // методы работают с общим объектом монитора
   public synchronized void produce(Message message) {
      try {
         while (messageQueue.size() >= maxStoredMessages) {
            wait();
         } // -> possible dead lock
         messageQueue.add(message);
         notify();
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }

   public synchronized Message consume() {
      try {
         while (messageQueue.isEmpty()) {
            wait();
         } // -> possible dead lock
         Message consumedMessage = messageQueue.poll();
         notify();
         return consumedMessage;
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
         throw new RuntimeException(e);
      }
   }
}
