package collection.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Интерфейс Deque расширяет интерфейс Queue и определяет поведение двунаправленной очереди,
 * которая работает как обычная однонаправленная очередь,
 * либо как стек, действующий по принципу LIFO (последний вошел - первый вышел).
 */

public class ArrayDequeSample {
   public static void main(String[] args) {
      Deque<String> deque = new ArrayDeque();
      // стандартное добавление элементов
      deque.add("A");
      deque.addFirst("B"); // добавляем элемент в самое начало
      deque.push("C");     // добавляем элемент в самое начало
      deque.addLast("D");  // добавляем элемент в конец коллекции
      deque.add("E");

      // получаем первый элемент без удаления
      System.out.println(deque.getFirst()); // Great Britain
      // получаем последний элемент без удаления
      System.out.println(deque.getLast());  // Italy
      System.out.printf("\n");

      System.out.printf("Queue size: %d \n", deque.size()); // 5
      System.out.printf("\n");

      // перебор коллекции -> C B A D E
      while (!deque.isEmpty()) {
         // извлечение c начала c последующем удалением, потому что идет привязка к первому элементу
         System.out.print(deque.pop() + " ");
      }
      System.out.println("\n");

      deque.add("A");
      deque.addFirst("B"); // добавляем элемент в самое начало
      deque.push("C");     // добавляем элемент в самое начало
      deque.addLast("D");  // добавляем элемент в конец коллекции
      deque.add("E");

      // извлечение c начала без удаления элементов необходимо использовать Iterator
      // Возвращает итератор по элементам в этой двухсторонней очереди
      // перебор коллекции -> C B A D E
      Iterator<String> it = deque.iterator();
      while (it.hasNext()) System.out.print(it.next() + " ");
      System.out.println("\n");

      // перебор коллекции -> C B A D E
      // используем `forEachRemaining()`, предоставляемый интерфейсом `java.util.Iterator`
      deque.iterator().forEachRemaining(System.out::print);
      System.out.println("\n");

      // извлечение c конца без удаления элементов необходимо использовать Iterator
      // Возвращает итератор по элементам в этой двухсторонней очереди
      // перебор коллекции -> E D A B C
      it = deque.descendingIterator();
      while (it.hasNext()) System.out.print(it.next() + " ");
      System.out.println("\n");

      // перебор коллекции -> E D A B C
      // используем `forEachRemaining()`, предоставляемый интерфейсом `java.util.Iterator`
      deque.descendingIterator().forEachRemaining(System.out::print);
      System.out.println("\n");
   }
}

