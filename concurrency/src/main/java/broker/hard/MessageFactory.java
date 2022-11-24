package broker.hard;

public final class MessageFactory {
   public static final int INITIAL_NEXT_MESSAGE_INDEX = 1;
   public static final String MESSAGE_DATA_TEMPLATE  = "Message#%d";
   private int nextMessageIndex;

   public MessageFactory() {
      this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
   }

   public Message create() {
      return new Message(String.format(MESSAGE_DATA_TEMPLATE, getIncrementNextMessageIndex()));
   }

   private synchronized int getIncrementNextMessageIndex() {
      return nextMessageIndex++;
   }
}
