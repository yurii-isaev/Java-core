package collection.map;

import java.util.*;

/**
 * HashMap -
 * Хэширование - это процесс преобразования объекта в целочисленную форму,
 * выполняется с помощью метода hashCode().
 * <p>
 * При добавлении нового элемента в HashMap:
 * 1. создается table - это массив, который является хранилищем ссылок на списки Entry<K,V>
 * 2. loadFactor - коэффициент загрузки.
 * Значение по умолчанию 0,75 и если на 75% таблица заполнена то она увеливается в 2 раза автоматически.
 * 3. Threshold - предельное количество элементов, при достижении которого, размер хэш-таблицы увеличивается вдвое.
 * Расчитывается по формулу (capacity * loadFactor).
 * По умолчанию объем = 16. 16 * 0.75 = 12.
 * Это значит, что при достижениие объекма в 12 элементов, размер будет увеличен на 100%.
 */

public class HashMapSample {
   public static void main(String[] args) {
      Map<Integer, String> map = new HashMap<>();
      map.put(1, "A");
      map.put(2, "B");
      map.put(3, "C");
      map.put(4, "D");
      String first = map.get(2);
      System.out.println(first); // B

      Set<Integer> set1 = map.keySet();       // возможность получить все ключи
      System.out.printf("maps: %s \n", set1); // [1, 2, 3, 4]

      Collection<String> set2 = map.values();   // возможность получить все значения
      System.out.printf("values: %s \n", set2); // [A, B, C, D]

      map.replace(1, "E"); // возможность изменения по ключу
      System.out.printf("values: %s \n", set2); // [E, B, C, D]

      map.remove(2); // возможность удаления по ключу
      System.out.printf("values: %s \n", set2); // [E, C, D]

      map.forEach((key, value) -> System.out.printf("Key: %d -> %s \n", key, value));
      // Key: 1 -> E
      // Key: 3 -> C
      // Key: 4 -> D

      // Задача: подсчитать количество дублей каждого числа в массиве произвольной длины
      Scanner sc = new Scanner(System.in);
      int size = sc.nextInt();
      int[] array = new int[size];

      Random rand = new Random();
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt(20);
      }

      Map<Integer, Integer> duplicates = new HashMap<>();
      System.out.println(Arrays.toString(array));

      for (int i : array) {
         if (duplicates.containsKey(i)) {
            int duplicate = duplicates.get(i); // получаем значение ключа = 0
            duplicates.put(i, ++duplicate);    // изменяем значение ключа = 1
         } else {
            duplicates.put(i, 0);
         }
      }
      duplicates.forEach((key, value) -> System.out.printf("Key: %d -> %s \n", key, value));
   }
}
