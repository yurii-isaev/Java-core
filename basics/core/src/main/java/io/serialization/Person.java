package io.serialization;

import java.io.Serializable;

/**
 * Сериализация — это конвертация состояния объекта в последовательность байт.
 * Данные байты сохраняются, как правило, в каком-либо файле.
 * Десериализация — это конвертация состояния объекта из последовательность байт.
 * Transient — это модификатор, указываемый перед полем класса для обозначения того,
 * что данное поле не должно быть сериализовано.
 * Поля, помеченные ключевым словом transient, не реализуют интерфейс Serializable.
 */

class Person implements Serializable {
   private String name;
   private int age;
   private double height;
   private transient boolean married;

   Person(String n, int a, double h, boolean m) {
      name = n;
      age = a;
      height = h;
      married = m;
   }

   String getName() {
      return name;
   }

   int getAge() {
      return age;
   }

   double getHeight() {
      return height;
   }

   boolean getMarried() {
      return married;
   }
}
