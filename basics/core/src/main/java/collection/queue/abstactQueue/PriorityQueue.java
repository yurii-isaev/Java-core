package collection.queue.abstactQueue;

import java.util.AbstractQueue;

/**
 * PriorityQueue — это специальный вид очереди, в которой испоьзуется натуральная сортировка
 * или та, которую мы описываем с помощью Comparable или Comparator.
 * Таким образом используется тот элемент из очереди, приоритет которго выше.
 *<p>
 * Класс PriorityQueue был введен в Java 1.5 и является частью Java Collections Framework.
 * PriorityQueue является неограниченной очередью.
 * Элементы упорядочены по умолчанию в естественном порядке или же отсортированы с помощью компаратора.
 * PriorityQueue не позволяет добавлять null-значения и non-comparable объекты.
 * Размер приоритетной очереди (PriorityQueue) неограничен, но мы можем указать начальный размер в момент его создания.
 * Когда мы добавляем элементы в приоритетную очередь, её размер увеличивается автоматически.
 * PriorityQueue не является потобезопасной!
 * Для этих целей в Java реализован класс PriorityBlockingQueue,
 * реализующий интерфейс BlockingQueue. Именно он используется в многопоточной среде.
 * В PriorityQueue добавление/удаление элементов происходит за время O(log(n)).
 */

public class PriorityQueue {
   public static void main(String[] args) {
      AbstractQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
      priorityQueue.add(4);
      priorityQueue.add(1);
      priorityQueue.add(7);
      priorityQueue.add(10);
      priorityQueue.add(8);
      System.out.println(priorityQueue.peek()); // 1
      while (!priorityQueue.isEmpty()) System.out.print(priorityQueue.poll() + " "); // 1 4 7 8 10
      System.out.println("\n");


      // Изменение порядка вывода с помощью компаратора
      AbstractQueue<Integer> queue = new java.util.PriorityQueue<>((o1, o2) -> o2 - o1);
      queue.add(4);
      queue.add(1);
      queue.add(7);
      queue.add(10);
      queue.add(8);
      System.out.println(queue.peek()); // 10
      while (!queue.isEmpty()) System.out.print(queue.poll() + " "); // 10 8 7 4 1
      System.out.println("\n");
   }
}
