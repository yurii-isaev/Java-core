package collection.map;

import unsafe.UnsafeAccess;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap, HashSet полагаются на методы equals(Object o) и hashCode()
 * для сравнения своих key и value;
 * Рефлексивность - объект должен равняться себе самому.
 * Симметричность - если a.equals(b) возвращает true и b.equals(с) тоже возвращает true,
 * то с.equals(a) тоже возвращает true.
 * Согласованность - повторный вызов метода equals() должен возвращать одно и тоже значениедо тех пор,
 * пока какое-либо значение свойств объекта не будет изменено. То есть, если два объекта равны в java,
 * то они будут равны пока их свойства остаются неизменными.
 * Сравнение null - объект должен быть проверен на null.
 * Если объект равен null, то метод должен вернуть false, а не NullPointerException.
 * <p/>
 * Если разные по equals объекты имеют одинаковый hashCode, то они складываются в одну ячейку
 * и там образуется LinkedList из полдобных объектов.
 */

public class HashModelSample {
   String name;
   String lastname;

   public HashModelSample(String name, String lastname) {
      this.name = name;
      this.lastname = lastname;
   }

   public static void main(String[] args) {
      // Указатели объектов с переопределенными equals(Object o) и hashCode()
      HashModelSample model1 = new HashModelSample("test", "test");
      System.out.println(model1.hashCode());               // 113808897
      System.out.println(System.identityHashCode(model1)); // 1922154895
      UnsafeAccess.printAddress(model1);                   // 0x440b37bc0

      model1 = new HashModelSample("test", "test");
      System.out.println(model1.hashCode());               // 113808897
      System.out.println(System.identityHashCode(model1)); // 885284298
      UnsafeAccess.printAddress(model1);                   // 0x440d7a580

      // Указатели объектов с без переопределенных equals(Object o) и hashCode()
      HashModelSample model2 = new HashModelSample("test", "test");
      System.out.println(model2.hashCode());               // 1922154895
      System.out.println(System.identityHashCode(model2)); // 1922154895
      UnsafeAccess.printAddress(model2);                   // 0x440b34540

      model2 = new HashModelSample("test", "test");
      System.out.println(model2.hashCode());               // 885284298
      System.out.println(System.identityHashCode(model2)); // 885284298
      UnsafeAccess.printAddress(model2);                   // 0x440b70c40

      Map<Integer, Integer> nums = new HashMap<>();
      nums.put(3, 3);
      nums.put(3, 3);
      nums.put(4, 3);
      nums.forEach((k, v) -> System.out.printf("nums: %s -> %s \n", k.hashCode(), v.hashCode()));
      // nums: 3 -> 3
      // nums: 4 -> 3

      Map<String, String> rows = new HashMap<>();
      rows.put("3", "3");
      rows.put("3", "3");
      rows.put("4", "3");
      rows.forEach((k, v) -> System.out.printf("rows: %s -> %s \n", k.hashCode(), v.hashCode()));
      // rows: 51 -> 51
      // rows: 52 -> 51

      // Перебор c помощью entry
      rows.entrySet().forEach(e -> System.out.println(e.getKey().hashCode()));
   }
}
