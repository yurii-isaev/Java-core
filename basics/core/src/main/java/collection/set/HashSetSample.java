package collection.set;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Класс HashSet интерфейс Set, он может хранить только уникальные значения;
 * Сортирует коллекцию по иерархии;
 * Может хранить NULL – значения;
 * Порядок добавления элементов вычисляется с помощью хэш-кода;
 * HashSet также реализует интерфейсы Serializable и Cloneable.
 * Для поддержания постоянного времени выполнения операций время,
 * затрачиваемое на действия с HashSet,
 * должно быть прямо пропорционально количеству элементов в HashSet
 * «емкость» встроенного экземпляра HashMap (количество «корзин»).
 * Поэтому для поддержания производительности очень важно
 * не устанавливать слишком высокую начальную ёмкость (или слишком низкий коэффициент загрузки).
 * Начальная емкость – изначальное количество ячеек («корзин») в хэш-таблице.
 * Если все ячейки будут заполнены, их количество увеличится автоматически.
 * На самом деле значение, которые мы передаем в HashSet, является ключом к объекту HashMap,
 * а в качестве значения в HashMap используется константа.
 * Таким образом, в каждой паре «ключ-значение» все ключи будут иметь одинаковые значения.
 * <p/>
 * Методы HashSet:
 * <p>
 * Метод {@link Set#add boolean add(E e)}:
 * добавляет элемент в HashSet, если таковой отсутствует,
 * если же такой элемент уже присутствует, метод возвращает false.
 * <p>
 * Метод {@link Set#clear void clear()}:
 * удаляет все элементы из множества.
 * <p>
 * Метод {@link Set#contains boolean contains(Object o)}:
 * возвращает true, если данный элемент присутствует в множестве.
 * <p>
 * Метод {@link Set#remove boolean remove(Object o)}:
 * удаляет данный элемент из множества, если таковой присутствует.
 * <p>
 * Метод {@link Set#iterator Iterator iterator()}:
 * возвращает итератор для элементов множества.
 * <p>
 * Метод {@link Set#isEmpty boolean isEmpty()}:
 * возвращает true, если в множестве нет элементов.
 * <p>
 */

public class HashSetSample {
   public static void main(String[] args) {
      Set<String> set = new HashSet<>();
      set.add("A");
      set.add("c");
      set.add("d");
      set.add("D");
      set.add("B");
      set.add("A");
      set.add("b");
      set.add(null);         // допускает наличие null
      System.out.print(set); // [null, A, B, b, c, d, D]
      System.out.println();
      System.out.println(set.isEmpty());
      System.out.print(set.add("A")); // false
      System.out.println();

      Set<Integer> nums = new HashSet<>();
      nums.add(5);
      nums.add(4);
      nums.add(2);
      nums.add(7);
      nums.add(3);
      nums.add(1);
      nums.add(6);
      nums.add(null);         // допускает наличие null
      System.out.print(nums); // [null, A, B, b, c, d, D]
      System.out.println();
      System.out.println();

      Set<Integer> set1 = new HashSet<>();
      set1.add(5);
      set1.add(2);
      set1.add(3);
      set1.add(1);
      set1.add(8);

      Set<Integer> set2 = new HashSet<>();
      set2.add(7);
      set2.add(4);
      set2.add(3);
      set2.add(5);
      set2.add(8);

      Set<Integer> union = new HashSet<>(set1);
      union.addAll(set2);      // производит объединение при добавлении
      System.out.print(union); // [1, 2, 3, 4, 5, 7, 8]
      System.out.println();

      Set<Integer> intersect = new HashSet<>(set1);
      intersect.retainAll(set2);   // производит выделение элементы пересечения
      System.out.print(intersect); // [3, 5, 8]
      System.out.println();

      Set<Integer> subtract = new HashSet<>(set1);
      subtract.removeAll(set2);   // производит выделение области которая есть в первом HashSet, но нет во втором
      System.out.print(subtract); // [1, 2]

      Set<Integer> set3 = new HashSet<>();
      set3.add(7);
      set3.add(4);
      set3.add(3);
      set3.add(5);
      set3.add(8);
      set3.remove(3);
      System.out.print(set3.contains(2)); // false
      System.out.println();
      System.out.print(set3.contains(3)); // false
      System.out.println();
      System.out.print(set3.contains(8)); // true
      System.out.println("\n");

      // Access elements of an array using index
      Integer[] array = set3.toArray(new Integer[set3.size()]);
      for (int i = 0; i < array.length; i++) {
         System.out.println("Element at index " + i + " is:" + array[i]);
      }
      int desiredIndex = Arrays.asList(array).get(2);
      System.out.println(desiredIndex); // 7
      System.out.println();

      // Access elements of an array using iterator
      desiredIndex = 2;
      int currentIndex = 0;
      Iterator<Integer> iterator = set3.iterator();
      while (iterator.hasNext()) {
         if (currentIndex == desiredIndex) {
            System.out.println("Element at index " + desiredIndex + " is: " + iterator.next());
         }
         iterator.next();
         currentIndex++;
      }
      System.out.println("\n");
   }
}
