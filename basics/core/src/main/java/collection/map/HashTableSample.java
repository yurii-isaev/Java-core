package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashTableSample {
   public static void main(String[] args) {
      Map<Integer, String> map = new HashMap<>(16, 1.1f);
      for (int i = 16; i >= 0 ; i--) {
         map.put(i, "" + i);
      }
      map.forEach((key, value) -> System.out.printf("Key: %d -> %s \n", key, value));
      System.out.println();
      // Key: 16 -> 16
      // Key: 0 -> 0
      // Key: 1 -> 1
      // Key: 2 -> 2
      // Key: 3 -> 3
      // Key: 4 -> 4
      // Key: 5 -> 5
      // Key: 6 -> 6
      // Key: 7 -> 7
      // Key: 8 -> 8
      // Key: 9 -> 9
      // Key: 10 -> 10
      // Key: 11 -> 11
      // Key: 12 -> 12
      // Key: 13 -> 13
      // Key: 14 -> 14
      // Key: 15 -> 15

      Map<Integer, String> linkedMap = new LinkedHashMap<>(16, 1.1f, false); // accessOrder = false
      for (int i = 16; i >= 0 ; i--) {
         linkedMap.put(i, "" + i);
      }
      linkedMap.get(3);
      linkedMap.get(3);
      linkedMap.get(3);
      linkedMap.get(6);
      linkedMap.get(9);
      linkedMap.forEach((key, value) -> System.out.printf("Key: %d -> %s \n", key, value));
      System.out.println();
      // Key: 16 -> 16
      // Key: 15 -> 15
      // Key: 14 -> 14
      // Key: 13 -> 13
      // Key: 12 -> 12
      // Key: 11 -> 11
      // Key: 10 -> 10
      // Key: 9 -> 9
      // Key: 8 -> 8
      // Key: 7 -> 7
      // Key: 6 -> 6
      // Key: 5 -> 5
      // Key: 4 -> 4
      // Key: 3 -> 3
      // Key: 2 -> 2
      // Key: 1 -> 1
      // Key: 0 -> 0

      Map<Integer, String> linkedMapOrder = new LinkedHashMap<>(16, 1.1f, true); // accessOrder = true
      for (int i = 16; i >= 0 ; i--) {
         linkedMapOrder.put(i, "" + i);
      }
      linkedMapOrder.get(3);
      linkedMapOrder.get(3);
      linkedMapOrder.get(3);
      linkedMapOrder.get(6);
      linkedMapOrder.get(9);
      linkedMapOrder.forEach((key, value) -> System.out.printf("Key: %d -> %s \n", key, value));
      System.out.println();
      // Key: 16 -> 16
      // Key: 15 -> 15
      // Key: 14 -> 14
      // Key: 13 -> 13
      // Key: 12 -> 12
      // Key: 11 -> 11
      // Key: 10 -> 10
      // Key: 8 -> 8
      // Key: 7 -> 7
      // Key: 5 -> 5
      // Key: 4 -> 4
      // Key: 2 -> 2
      // Key: 1 -> 1
      // Key: 0 -> 0
      // Key: 3 -> 3
      // Key: 6 -> 6
      // Key: 9 -> 9
   }
}
