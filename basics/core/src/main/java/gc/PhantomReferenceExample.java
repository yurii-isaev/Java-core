package gc;

import java.lang.ref.Reference;
import java.lang.ref.*;

public class PhantomReferenceExample {
   public static void main(String[] args) {
      Object obj = new Object();
      ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
      PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);

      System.out.println(phantomReference);

      // Создаем поток, который будет отслеживать очередь ссылок и выполнять дополнительные действия при удалении объекта
      Thread cleanupThread = new Thread(() -> {
         try {
            // Ожидаем, пока объект не будет удален и добавлен в очередь ссылок
            System.out.println(phantomReference);
            Reference<?> reference = referenceQueue.remove();
            if (reference == phantomReference) {
               // Выполняем дополнительные действия перед окончательным удалением объекта
               System.out.println("Perform resource cleanup for an object");
            }
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
         }
      });

      // Удаляем объект
      obj = null;

      // Запускаем сборку мусора
      System.gc();

      // Запускаем поток очистки
      cleanupThread.start();

      /*
      java.lang.ref.PhantomReference@7291c18f
      java.lang.ref.PhantomReference@7291c18f
      Perform resource cleanup for an object
       */
   }
}
