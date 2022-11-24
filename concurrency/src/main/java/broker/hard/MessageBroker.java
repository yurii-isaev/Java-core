package broker.hard;

import java.util.*;

public final class MessageBroker {

   private final Queue<Message> messageQueue;
   private final int maxStoredMessages;

   public MessageBroker(int maxMessages) {
      this.messageQueue = new ArrayDeque<>(maxMessages);
      this.maxStoredMessages = maxMessages;
   }

   // методы работают с общим объектом монитора
   public synchronized void produce(Message message, MessageProducingTask task) {
      try {
         while (!isShouldProduce(task)) {
            wait();
         } // -> possible dead lock
         messageQueue.add(message);

         System.out.printf("Message '%s' is produced by producer '%s'." +
             " Amount of message before producing: %d\n",
             message, task.getName(), messageQueue.size() - 1);

         notify();
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }

   public synchronized Optional<Message> consume(MessageConsumingTask task) {
      try {
         while (!isShouldConsume(task)) {
            wait();
         } // -> possible dead lock
         Message consumedMessage = messageQueue.poll();

         System.out.printf("Message '%s' is consumed by consumer '%s'." +
             " Amount of message before consuming: %d\n",
             consumedMessage, task.getName(), messageQueue.size() + 1);

         notify();
         return Optional.ofNullable(consumedMessage);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
         throw new RuntimeException(e);
      }
   }

   private boolean isShouldProduce(MessageProducingTask task) {
      return messageQueue.size() < maxStoredMessages
          && messageQueue.size() <= task.getMinimalAmountMessagesToProduce();
   }

   private boolean isShouldConsume(MessageConsumingTask task) {
      return !messageQueue.isEmpty()
          && messageQueue.size() >= task.getMinimalAmountMessagesToConsume();

   }
}
