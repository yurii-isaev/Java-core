package collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс TreeSet интерфейс Set, он может хранить только уникальные значения;
 * Сортирует коллекцию по иерархии;
 * Может хранить NULL – значения;
 * Порядок добавления элементов вычисляется с помощью хэш-кода;
 * Отсутствует метод get(), получение даннных через компоратор -> O(n)
 * HashSet также реализует интерфейсы NavigableSet<E>, Serializable и Cloneable.
 */

public class TreeSetSample {
   public static void main(String[] args) {
      Set<String> set = new TreeSet<>();
      set.add("A");
      set.add("c");
      set.add("d");
      set.add("D");
      set.add("B");
      set.add("A");
      set.add("b");
      // set.add(null);      // не допускает наличие null в наборе строк
      System.out.print(set); // [A, B, D, b, c, d]
      System.out.println();
      System.out.println(set.isEmpty()); // false
      System.out.print(set.add("A"));    // false
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
      System.out.print(nums); // [null, 1, 2, 3, 4, 5, 6, 7]
      System.out.println();

      Set<Integer> set1 = new TreeSet<>();
      set1.add(5);
      set1.add(2);
      set1.add(3);
      set1.add(1);
      set1.add(8);

      Set<Integer> set2 = new TreeSet<>();
      set2.add(7);
      set2.add(4);
      set2.add(3);
      set2.add(5);
      set2.add(8);

      Set<Integer> union = new TreeSet<>(set1);
      union.addAll(set2);      // производит объединение при добавлении
      System.out.print(union); // [1, 2, 3, 4, 5, 7, 8]
      System.out.println();

      Set<Integer> intersect = new TreeSet<>(set1);
      intersect.retainAll(set2);   // производит выделение элементы пересечения
      System.out.print(intersect); // [3, 5, 8]
      System.out.println();

      Set<Integer> subtract = new TreeSet<>(set1);
      subtract.removeAll(set2);   // производит выделение области которая есть в первом HashSet, но нет во втором
      System.out.print(subtract); // [1, 2]
      System.out.println();

      Set<Integer> set3 = new TreeSet<>();
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
   }
}
