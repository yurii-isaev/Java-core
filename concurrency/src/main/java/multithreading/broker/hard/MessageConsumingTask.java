package multithreading.broker.hard;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class MessageConsumingTask implements Runnable {

   private final MessageBroker messageBroker;
   private final int minimalAmountMessagesToConsume;
   private final String name;

   public MessageConsumingTask(
       MessageBroker messageBroker,
       int minimalAmountMessages,
       String name)
   {
      this.messageBroker = messageBroker;
      this.minimalAmountMessagesToConsume = minimalAmountMessages;
      this.name = name;
   }

   public int getMinimalAmountMessagesToConsume() {
      return minimalAmountMessagesToConsume;
   }

   public String getName() {
      return name;
   }

   @Override
   public void run() {
      try {
         while (!Thread.currentThread().isInterrupted()) {
            TimeUnit.SECONDS.sleep(3);
            Optional<Message> optionalConsumedMessage = messageBroker.consume(this);
            optionalConsumedMessage.orElseThrow(MessageConsumerException::new);

         }
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
}
