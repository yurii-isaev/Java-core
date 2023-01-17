package multithreading.broker.easy;

import java.util.concurrent.TimeUnit;

public class MessageConsumingTask implements Runnable {
   private final MessageBroker messageBroker;

   public MessageConsumingTask(MessageBroker messageBroker) {
      this.messageBroker = messageBroker;
   }

   @Override
   public void run() {
      try {
         while (!Thread.currentThread().isInterrupted()) {
            TimeUnit.SECONDS.sleep(3);
            Message consumedMessage = messageBroker.consume();
            System.out.printf("Message '%s' is consumed.\n", consumedMessage);
         }
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
}
