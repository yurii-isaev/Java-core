package multithreading.broker.easy;

public class Runner {
   public static void main(String[] args) {
      final int brokerMaxMessage = 5;
      MessageBroker messageBroker = new MessageBroker(brokerMaxMessage);
      Thread producingThread = new Thread(new MessageProducingTask(messageBroker));
      Thread consumingThread = new Thread(new MessageConsumingTask(messageBroker));

      producingThread.start();
      consumingThread.start();
   }
}
