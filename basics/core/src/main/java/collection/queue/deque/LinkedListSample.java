package collection.queue.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LinkedList — это линейная структура данных, хранящая последовательность элементов и
 * которая следует принципу FIFO (First-In, First-Out).
 * Это означает, что объект, вставленный первым, будет извлечен первым, а затем объект, вставленный следующим.
 * <p/>
 * LinkedList поддерживает следующие основные операции:
 * add: Добавляет элемент в конец очереди и выдает исключение, если добавление выше возможного.
 * offer: Вставляет элемент в конец queue и не выдает исключение, если добавление выше возможного.
 * remove: Удаляет объект из начала queue и возвращает его, тем самым уменьшая размер queue на единицу
 * и выдает исключение, если добавление выше возможного.
 * poll: Удаляет объект из начала queue и возвращает его, тем самым уменьшая размер queue на единицу
 * Peek: Возвращает объект в начале queue, не удаляя его.
 * Element: показывет первый элемент в очереди и выбрасывает исключение.
 * Peek: показывет первый элемент в очереди и возвращает null.
 * <p>
 * Queue — это линейная структура данных, хранящая последовательность элементов и
 * которая следует принципу FIFO (First-In, First-Out).
 * Это означает, что объект, вставленный первым, будет извлечен первым, а затем объект, вставленный следующим.
 * <p/>
 * Queue поддерживает следующие основные операции:
 * Enqueue: Вставляет элемент в конец queue.
 * Dequeue: Удаляет объект из начала queue и возвращает его, тем самым уменьшая размер queue на единицу.
 * Peek: Возвращает объект в начале queue, не удаляя его.
 * IsEmpty: Проверяет, пуста queue или нет.
 * Size: Возвращает общее количество элементов, присутствующих в queue.
 */
public class LinkedListSample {
   public static void main(String[] args) {
      Deque<String> queue = new LinkedList<>();
      queue.add("A");
      queue.add("B");
      queue.add("C");
      queue.add("D");
      queue.add("E");

      //region Remove
      System.out.println(queue);
      System.out.println(queue.remove());
      System.out.println(queue.remove());
      System.out.println(queue.remove());
      System.out.println(queue.remove());
      System.out.println(queue.remove());
      System.out.println(queue.remove()); // -> NoSuchElementException
      System.out.println(queue);
      //endregion

      //region Poll
      System.out.println(queue);
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll()); // -> null
      System.out.println(queue);
      //endregion

      //region Peek
      System.out.println(queue);
      System.out.println(queue.poll());
      System.out.println(queue.element());
      System.out.println(queue.poll());
      System.out.println(queue.element());
      System.out.println(queue.poll());
      System.out.println(queue.element());
      System.out.println(queue.poll());
      System.out.println(queue.element());
      System.out.println(queue.poll());
      System.out.println(queue.element());
      System.out.println(queue.poll()); // -> NoSuchElementException
      //endregion

      //region Peek
      System.out.println(queue);
      //System.out.println(queue.poll());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue.peek()); // -> null
      System.out.println(queue.poll());
      //endregion
   }
}
