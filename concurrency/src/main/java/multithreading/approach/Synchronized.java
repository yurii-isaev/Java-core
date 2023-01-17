package multithreading.approach;

/**
 * В Java критическая секция синхронизированного кода - это участок кода,
 * в котором доступ к общим ресурсам или
 * общим данным контролируется с использованием механизма синхронизации.
 * Когда блок кода или метод помечен ключевым словом "synchronized", он становится критической секцией.
 * <p>
 * Когда поток входит в критическую секцию, он получает монитор объекта,
 * на котором вызывается синхронизированный блок кода или метод.
 * Это означает, что только один поток может одновременно выполнять код в критической секции.
 * Если другой поток пытается войти в критическую секцию, пока первый поток еще находится внутри,
 * он будет заблокирован и ожидать, пока первый поток не покинет критическую секцию.
 * <p>
 * Такой механизм синхронизации позволяет избежать состояний гонки,
 * когда несколько потоков одновременно пытаются изменить общие данные.
 * Он обеспечивает согласованность данных и предотвращает возникновение ошибок,
 * связанных с несогласованным доступом к общим ресурсам.
 * <p>
 * Однако использование синхронизации может вызывать проблемы с производительностью,
 * особенно если критическая секция содержит много операций или вызывается часто.
 * Поэтому в Java также предоставляются другие механизмы синхронизации,
 * такие как блокировки (Locks),
 * атомарные операции и синхронизированные коллекции,
 * которые могут быть более эффективными в определенных ситуация
 * <p>
 * Синхронизация нужна только в тех местах, где есть какие-то ресурсы,
 * к которым может обращаться одновременно несколько потоков.
 * Например, если есть очередь задач, из которой потоки берут задачи и выполняют,
 * то доступ к очереди должен быть синхронизирован, чтоб не было накладок типа того,
 * что два потока одну задачу возьмут. А сами задачи уже можно выполнять параллельно.
 * В общем, обычно синхронизацию используют по минимуму и только в необходимых местах.
 */

public class Synchronized {
   public static void main(String[] args) {
      example1();
      example2();
   }

   private static int counter;

   public static void example1() {
      Runnable runnable = new Runnable() {
         @Override
         public void run() {
            synchronized (this) { // = synchronized public void run()
               counter = 0;
               for (int i = 0; i < 5; i++) {
                  counter = counter + 1;
                  System.out.println(Thread.currentThread().getName() + ": " + counter);
               }
            }
         }
      };

      Thread thread1 = new Thread(runnable);
      Thread thread2 = new Thread(runnable);

      thread1.start();
      thread2.start();

      try {
         thread1.join();
         thread2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static void example2() {
      // StringBuilder - не является потоко-безопасным и методы его не синхронизированы
      StringBuffer stringBuilder = new StringBuffer();

      Runnable runnable = () -> stringBuilder
          .append("long hello world from thread : ")
          .append(Thread.currentThread().getName())
          .append("\n");

      Thread thread1 = new Thread(runnable);
      Thread thread2 = new Thread(runnable);
      Thread thread3 = new Thread(runnable);
      Thread thread4 = new Thread(runnable);

      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();

      try {
         thread1.join();
         thread2.join();
         thread3.join();
         thread4.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      System.out.println(stringBuilder);
   }
}
