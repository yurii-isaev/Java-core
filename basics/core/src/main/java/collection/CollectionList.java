package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.*;

/**
 * 1. Реализация
 * ArrayList - это реализация интерфейса list с изменяемым размером массива, в то время как
 * LinkedList - это двусвязная реализация list интерфейса list.
 * <p/>
 * 2. Производительность
 * получение (int index) или операция поиска
 * операция get().
 * O(1) для ArrayList, потому что ArrayList разрешает произвольный доступ с помощью индекса.
 * O(n) для LinkedList, потому что сначала нужно найти индекс.
 * Причина того, что ArrayList быстрее LinkedList, заключается в том, что
 * ArrayList использует систему на основе индексов для своих элементов, поскольку,
 * с другой стороны, он внутренне использует структуру данных массива,
 * <p>
 * LinkedList не предоставляет доступ к своим элементам на основе индекса,
 * поскольку он выполняет итерацию либо с начала, либо с конца (в зависимости от того, что ближе)
 * для извлечения узла с указанным индексом элемента.
 * <p>
 * операция insert() или add(Object)
 * O(n) для ArrayList, потому что ArrayList разрешает произвольный доступ с помощью индекса.
 * O(1) для LinkedList, потому что сначала нужно найти индекс.
 * <p>
 * В то время как в ArrayList, если массив является полным,
 * т. е. в худшем случае, возникают дополнительные затраты на изменение размера массива и копирование элементов в новый массив,
 * что делает время выполнения операции добавления в ArrayList O(n), в противном случае это O(1).
 * <p>
 * операция удаления (int)
 * Операция удаления в LinkedList обычно такая же, как в ArrayList, т. Е. O(n).
 * В LinkedList есть два перегруженных метода удаления. один из них - remove() без какого-либо параметра,
 * который удаляет заголовок списка и выполняется с постоянным временем O(1).
 * Другим перегруженным методом remove в LinkedList является remove(int) или remove(Object),
 * который удаляет объект или int, переданный в качестве параметра.
 * Этот метод обходит LinkedList до тех пор, пока не найдет объект и не отсоединит его от исходного списка.
 * Следовательно, время выполнения этого метода равно O(n).
 * В то время как в методе ArrayList remove(int) выполняется копирование элементов из старого массива в новый обновленный массив,
 * следовательно, его время выполнения равно O(n).
 * <p/>
 * 3. Обратный итератор
 * LinkedList может быть повторен в обратном направлении с помощью descendingIterator(), в то время как
 * в ArrayList нет функции descendingIterator(),
 * поэтому нам нужно написать наш собственный код для выполнения итерации по ArrayList в обратном направлении.
 * <p/>
 * 4. Начальная емкость
 * Если конструктор не перегружен, то ArrayList создает пустой список начальной емкости 10, в то время как
 * LinkedList создает только пустой список без какой-либо начальной емкости.
 * <p/>
 * 5. Накладные расходы на память
 * Нагрузка на память в LinkedList больше по сравнению с ArrayList,
 * поскольку узлу в LinkedList необходимо сохранять адреса следующего и предыдущего узлов.
 * В то время как в ArrayList каждый индекс содержит только фактический объект (данные).
 */

public class CollectionList {
   public static void main(String[] args) {
      List<Integer> arrayList = new ArrayList<>();
      List<Integer> linkedList = new LinkedList<>();

      //region Adding
      long start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) arrayList.add(i); // 15 ms
      long end = currentTimeMillis();
      out.println("Time adding for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) linkedList.add(i); // 10 ms
      end = currentTimeMillis();
      out.println("Time adding for linked list is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Setting
      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) arrayList.set(i, 1);
      end = currentTimeMillis(); // 5 ms
      out.println("Time setting for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) linkedList.set(i, 1);
      end = currentTimeMillis(); // 35 000 ms
      out.println("Time setting for linked list is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Getting
      start = currentTimeMillis();
      for (int i = 0; i < arrayList.size(); i++) arrayList.get(i);
      end = currentTimeMillis(); // 5 ms
      out.println("Time taken for array list is " + (end - start) + " ms");

      //start = currentTimeMillis();
      //for (int i = 0; i < linkedList.size(); i++) {
      //   linkedList.get(i); // 53830 ms
      //}
      //end = currentTimeMillis();
      //out.println("Time taken for linked list is " + (end - start) + " ms");

      // Решение проблемы извлечение элементов с помошью итератора
      start = currentTimeMillis();
      Iterator<Integer> iterator = linkedList.iterator();
      while (iterator.hasNext()) iterator.next();
      end = currentTimeMillis(); // 20 ms
      out.println("Time taken for linked list is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Deleting
      start = currentTimeMillis();
      for (int i = 0; i < arrayList.size(); i++) arrayList.remove(i);
      end = currentTimeMillis(); // 1000 ms
      out.println("Time deleted for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < linkedList.size(); i++) linkedList.remove(i);
      end = currentTimeMillis(); // 14 000 ms
      out.println("Time deleted for linked list is " + (end - start) + " ms");
      out.println();
      //endregion
   }
}
