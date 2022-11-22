package broker.easy;

import java.util.concurrent.TimeUnit;

public class MessageProducingTask implements Runnable {
   public static final String MESSAGE_IS_PRODUCED = "Message '%s' is produced.\n";
   private final MessageBroker messageBroker;
   private final MessageFactory messageFactory;

   public MessageProducingTask(MessageBroker messageBroker) {
      this.messageBroker = messageBroker;
      this.messageFactory = new MessageFactory();
   }

   @Override
   public void run() {
      try {
         while (!Thread.currentThread().isInterrupted()) {
            Message producedMessage = messageFactory.create();
            TimeUnit.SECONDS.sleep(1);
            messageBroker.produce(producedMessage);
            System.out.printf(MESSAGE_IS_PRODUCED, producedMessage);
         }
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }

   public static final class MessageFactory {
      public static final int INITIAL_NEXT_MESSAGE_INDEX = 1;
      public static final String MESSAGE_DATA_TEMPLATE  = "Message#%d";
      private int nextMessageIndex;

      public MessageFactory() {
         this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
      }

      public Message create() {
         return new Message(String.format(MESSAGE_DATA_TEMPLATE, nextMessageIndex++));
      }
   }
}
