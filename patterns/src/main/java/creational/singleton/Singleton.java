package creational.singleton;

public class Singleton {
   private static Singleton instance = null;

   // Закрытый конструктор, чтобы предотвратить создание экземпляров класса извне
   private Singleton() {
   }

   // Метод для получения единственного экземпляра класса
   // Шаблон "Double-Checked Locking" — параллельный шаблон проектирования,
   // предназначающийся для уменьшения накладных расходов, связанных с получением блокировки.
   // Сначала проверяется условие блокировки без какой-либо синхронизации;
   // поток делает попытку получить блокировку, только если результат проверки говорит о том,
   // что получение блокировки необходимо.
   public static Singleton getInstance() {
      if (instance == null) {
         synchronized (Singleton.class) {
            if (instance == null) {
               instance = new Singleton();
            }
         }
      }
      return instance;
   }

   // Другие методы класса
   public void doSomething() {
      System.out.println("Method called doSomething()");
   }
}
