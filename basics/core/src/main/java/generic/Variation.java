package generic;

import java.util.ArrayList;
import java.util.List;

public class Variation {

   static class Fruit {
      int weight;
   }

   static class Citrus extends Fruit {
      int weight;
   }

   static class Orange extends Citrus {
      int weight;
   }

   public static void main(String[] args) {
      Fruit fruit = new Fruit();
      Citrus citrus = new Citrus();
      Orange orange = new Orange();

      // Логика наследования без ошибок
      fruit = citrus;
      citrus = orange;
      fruit = orange;

      // Логика наследования с ошибками
      // citrus = fruit;
      // orange = citrus;
      // orange = fruit;

      List<Citrus> citrusList = new ArrayList<>();
      fruit = citrusList.get(0);
      citrus = citrusList.get(0);
      orange = (Orange) citrusList.get(0);

      List<Orange> orangeList = new ArrayList<>();
      // citrusList = orangeList; // -> запрещено, поскольку обощенные классы являются инвариантными типами
   }

   // Инариантность типов
   // Получаемый список в парметре для записи объекта и наследников и для чтения объекта и его предков
   private static void getFruits(List<Citrus> oranges) {
      for (int i = 0; i < oranges.size(); i++) {
         oranges.add(new Citrus());
         oranges.add(new Orange());
         // oranges.add(new Fruit());       // Ошибка !! -> нет возможности записи предка
         Citrus citrus = oranges.get(0);
         Fruit fruit = oranges.get(0);
         // Orange orange = oranges.get(0); // Ошибка !! -> класс Orange не предок Citrus
      }
   }

   // Ковариантность типов
   // Получаемый список в парметре не для записи, а для чтения объекта и его предков
   private static void getOranges(List<? extends Citrus> oranges) {
      for (int i = 0; i < oranges.size(); i++) {
         // oranges.add(new Citrus());      // Ошибка !! -> нет возможности записи
         Citrus citrus = oranges.get(0);
         Fruit fruit = oranges.get(0);
         // Orange orange = oranges.get(0); // Ошибка !! -> класс Orange не предок Citrus
      }
   }

   // Контрвариантность типов
   // Получаемый список в парметре не для чтения, а для записи объекта и его наследников
   private static void addOranges(List<? super Citrus> oranges) {
      for (int i = 0; i < oranges.size(); i++) {
         // oranges.add(new Fruit());     // Ошибка !! -> класс Fruit не наследник Citrus
         oranges.add(new Citrus());
         oranges.add(new Orange());
      }
      // Orange citrus = oranges.get(0); // Ошибка !! -> нет возможности получить класс
      Object citrus = oranges.get(0);    // Получает только объекты класса Object
   }
}
