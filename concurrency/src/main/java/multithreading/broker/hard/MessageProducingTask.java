package multithreading.broker.hard;

import java.util.concurrent.TimeUnit;

public class MessageProducingTask implements Runnable {

   private final MessageBroker messageBroker;
   private final MessageFactory messageFactory;
   private final int minimalAmountMessagesToProduce;
   private final String name;

   public MessageProducingTask(
       MessageBroker messageBroker,
       MessageFactory messageFactory,
       int minimalAmountMessages,
       String name)
   {
      this.messageBroker = messageBroker;
      this.messageFactory = messageFactory;
      this.minimalAmountMessagesToProduce = minimalAmountMessages;
      this.name = name;
   }

   public int getMinimalAmountMessagesToProduce() {
      return minimalAmountMessagesToProduce;
   }

   public String getName() {
      return name;
   }

   @Override
   public void run() {
      try {
         while (!Thread.currentThread().isInterrupted()) {
            Message producedMessage = messageFactory.create();
            TimeUnit.SECONDS.sleep(1);
            messageBroker.produce(producedMessage, this);
         }
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
}
