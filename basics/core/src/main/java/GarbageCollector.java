import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * -Xms<size> - начальный размер кучи
 * -Xmx<size> - максимальный размер кучи
 * -Xmn<size> устанавливает начальный и максимальный размер (в байтах) кучи для молодого поколения
 * -Xss - размер стека потоков
 * --XX:HeapDumpOnOutOfMemory - создаст файл дампа кучи, когда эта ошибка произойдет в слудующий раз
 * -verbose:gc - для вывода процесса сборки мусора
 */

public class GarbageCollector {
   // Общее количество памяти, которое доступно JVM
   // Runtime.getRuntime().maxMemory();

   // Количество памяти, которое было зарезервировано для выполнения программы JVM
   // Runtime.getRuntime().totalMemory();

   // Текущее количество памяти в процессу выполнения программы
   // Runtime.getRuntime().freeMemory();

   public static void main(String[] args) {
      // Память, которая была зарезервирована JVM: 1048 Мб из 2044 Мб общедоступной JVM

      List<Object> list = new ArrayList<>();
      for (int i = 0; i < 15_000_000; i++) {
         list.add(new Item(i));
      }
      printMemory(); // Израсходовано: 482 Мб

      // Остаток памяти: 566 Мб и 1562 Мб общедоступной JVM
   }

   public static class Item {
      int id;
      public Item(int id) {
         this.id = id;
      }

   }
   private static void printMemory() {
      out.println("Max mem: " + Runtime.getRuntime().maxMemory() / 1048576);
      out.println("Total mem: " + Runtime.getRuntime().totalMemory() / 1048576);
      out.println("Free available mem: " + Runtime.getRuntime().freeMemory() / 1048576);

      long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      out.println("Used mem: " + usedMemory / 1048576);

      long freeMemory = Runtime.getRuntime().maxMemory() - usedMemory;
      out.println("Free mem: " + freeMemory / 1048576);

      out.println("___________________________________________");
   }
}
