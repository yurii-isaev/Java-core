package collection.map;

import unsafe.UnsafeAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
 */

public class HashModelSample {
   String name;
   String lastname;

   public HashModelSample(String name, String lastname) {
      this.name = name;
      this.lastname = lastname;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      HashModelSample that = (HashModelSample) o;
      return name.equals(that.name) && lastname.equals(that.lastname);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, lastname);
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

      Map<String, Integer> nums = new HashMap<>();
      nums.put("3", 100);
      nums.put("3", 100);
     // System.out.println(nums.containsKey(28).hashCode());
      nums.forEach((key, value) -> System.out.printf("Key: %s -> %s \n", key.hashCode(), value));

//      for(String key: nums.keySet()) {
//         if(nums.get(key).equals(100)) {
//            System.out.println(key);
//            System.out.println(nums.keySet().hashCode());
//         }
//      }

   }
}
