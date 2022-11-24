package broker.hard;

import java.util.Arrays;

public class Runner {
   public static void main(String[] args) {
      final int brokerMaxMessage = 3;
      MessageBroker messageBroker = new MessageBroker(brokerMaxMessage);
      MessageFactory messageFactory = new MessageFactory();

      Thread firstProducingThread = new Thread(new MessageProducingTask
          (messageBroker, messageFactory, brokerMaxMessage, "producer_1"));

      Thread secondProducingThread = new Thread(new MessageProducingTask
          (messageBroker, messageFactory, 10, "producer_2"));

      Thread thirdProducingThread = new Thread(new MessageProducingTask(
          messageBroker, messageFactory, 5, "producer_3"));

      Thread firstConsumingThread = new Thread(new MessageConsumingTask
          (messageBroker, 0, "consumer_1"));

      Thread secondConsumingThread = new Thread(new MessageConsumingTask
          (messageBroker, 6, "consumer_2"));

      Thread thirdConsumingThread = new Thread(new MessageConsumingTask
          (messageBroker, 11, "consumer_3"));

     runner(firstProducingThread, secondProducingThread, thirdProducingThread,
         firstConsumingThread, secondConsumingThread, thirdConsumingThread);
   }

   public static void runner(Thread... threads) {
      Arrays.stream(threads).forEach(Thread::start);
   }
}
