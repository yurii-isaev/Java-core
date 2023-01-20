package gc;

import java.lang.ref.*;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceExample {
   public static void main(String[] args) {
      /**
       * Сильные ссылки (Strong References):
       * Это наиболее распространенный тип ссылок в Java.
       * Когда объект имеет сильную ссылку, он не будет собран сборщиком мусора,
       * даже если на него больше нет других ссылок.
       * Сильные ссылки устанавливаются по умолчанию при создании объекта.
       */
      Object object = new Object();
      // Strong reference: java.lang.Object@312b1dae

      /**
       * Слабые ссылки (Weak References):
       * Слабые ссылки используются для указания на объект,
       * который может быть собран сборщиком мусора, если на него больше нет сильных ссылок.
       * Слабые ссылки полезны, когда требуется временное хранение объекта,
       * который может быть удален, если нет других активных ссылок на него.
       * В Java слабые ссылки могут быть созданы с помощью класса WeakReference.
       */
      WeakReference<Object> weakRef = new WeakReference<>(object);
      // Weak reference: java.lang.ref.WeakReference@7530d0a
      // Weak reference object: java.lang.Object@312b1dae

      /**
       * Мягкие ссылки (Soft References):
       * Мягкие ссылки также используются для указания на объект,
       * который может быть собран сборщиком мусора, но только если системе не хватает памяти.
       * Если на объект есть только мягкая ссылка, он будет удален, чтобы освободить память.
       * Мягкие ссылки могут быть созданы с помощью класса SoftReference.
       */
      //SoftReference<Object> softRef = new SoftReference<>(object);
      // Soft reference: java.lang.Object@312b1dae

      /**
       * Фантомные ссылки (Phantom References):
       * Фантомные ссылки используются для отслеживания момента,
       * когда объект удаляется сборщиком мусора.
       * Они не могут быть использованы для доступа к объекту напрямую,
       * но могут быть использованы для выполнения некоторых действий перед удалением объекта.
       * Фантомные ссылки могут быть созданы с помощью класса PhantomReference.
       */
      ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
      PhantomReference<Object> phantomRef = new PhantomReference<>(object, referenceQueue);

      // Проверяем, была ли фантомная ссылка добавлена в очередь ссылок
      Reference<?> referenceFromQueue;
      while ((referenceFromQueue = referenceQueue.poll()) != null) {
         if (referenceFromQueue == phantomRef) {
            // Выполняем дополнительные действия перед окончательным удалением объекта
            System.out.println("Выполняем очистку ресурсов для объекта");
         }
      }

      object = null;
      System.gc();
      System.out.println("After gc called");

      System.out.printf("Strong reference: %s\n", object);
      System.out.printf("Weak reference: %s\n", weakRef.get());
      //System.out.printf("Soft reference: %s\n", softRef.get());

      System.out.printf("Phantom reference: %s\n", phantomRef.get());
      System.out.printf("Reference queue poll: %s\n", referenceQueue.poll());

      /**
       * AtomicReference в Java представляет собой класс,
       * который обеспечивает атомарные операции чтения и записи для ссылочных типов данных.
       * Он позволяет обновлять ссылочное значение без блокировки или синхронизации и гарантирует,
       * что операции выполняются атомарно.
       * То есть, эти операции выполняются как единое целое и не могут быть прерваны.
       */
      AtomicReference<Object> atomicRef = new AtomicReference<>(object);

      // Получение текущего значения
      System.out.println("AtomicReference: " + atomicRef.get());

      // Установка нового значения с помощью compareAndSet()
      atomicRef.set(new Object());

      // Получение обновленного значения
      System.out.println("Updated value: " + atomicRef.get());

      /*
      After gc called
      Strong reference: java.lang.Object@312b1dae
      Weak reference: java.lang.Object@312b1dae
      Soft reference: java.lang.Object@312b1dae
      Phantom reference: null
      Reference queue poll: null
      AtomicReference: java.lang.Object@312b1dae
      Updated value: java.lang.Object@506e1b77
       */
   }
}
