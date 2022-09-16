package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * 1. Vector синхронизирован по умолчанию, а ArrayList - нет.
 * Синхронизированный означает: его можно использовать с несколькими потоками без какого-либо побочного эффекта.
 * <p/>
 * 2. Списки массивов увеличиваются на 50% от предыдущего размера,
 * когда для нового элемента недостаточно места, тогда как вектор будет увеличиваться на 100% от предыдущего размера,
 * когда нет места для нового входящего элемента.
 * <p/>
 * Желающие реализовать потокобезопасный список, используют CopyOnWriteArrayList.
 * <p>
 * ArrayList всегда должно быть предпочтительнее, чем Vector.
 * А Vector является устаревшим классом, который устарел, и его следует избегать любой ценой.
 * Vector class не был включен как часть Java Collection Framework и был включен позже.
 * Мы уже упоминали о том, что Vector синхронизирован, но не полностью потокобезопасен.
 * Vector также имеет накладные расходы на блокировку независимо от того, требуется синхронизация или нет.
 * <p>
 * Если поточно-безопасная реализация List требуется интерфейс,
 * мы можем либо использовать CopyOnWriteArrayList класс,
 * который является потокобезопасным вариантом класса ArrayList или
 * синхронизировать ArrayList внешне с помощью Collections.synchronizedList() метод.
 */
public class CollectionVector {
   public static void main(String[] args) {
      List<Integer> arrayList = new ArrayList<>();
      List<Integer> vector = new Vector<>();

      //region Adding
      long start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) arrayList.add(i);
      long end = currentTimeMillis(); // 30 ms
      out.println("Time adding for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) vector.add(i);
      end = currentTimeMillis(); // 60 ms
      out.println("Time adding for vector is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Setting
      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) arrayList.set(i, 1);
      end = currentTimeMillis(); // 20 ms
      out.println("Time setting for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < 100000; i++) vector.set(i, 1);
      end = currentTimeMillis(); // 20 ms
      out.println("Time setting for vector is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Getting
      start = currentTimeMillis();
      for (int i = 0; i < arrayList.size(); i++) arrayList.get(i);
      end = currentTimeMillis(); // 5 ms
      out.println("Time taken for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < vector.size(); i++) vector.get(i);
      end = currentTimeMillis(); // 10 ms
      out.println("Time taken for vector is " + (end - start) + " ms");
      out.println();
      //endregion

      //region Deleting
      start = currentTimeMillis();
      for (int i = 0; i < arrayList.size(); i++) arrayList.remove(i);
      end = currentTimeMillis(); // 1200 ms
      out.println("Time deleted for array list is " + (end - start) + " ms");

      start = currentTimeMillis();
      for (int i = 0; i < vector.size(); i++) vector.remove(i);
      end = currentTimeMillis(); // 800 ms
      out.println("Time deleted for vector is " + (end - start) + " ms");
      out.println();
      //endregion
   }
}
