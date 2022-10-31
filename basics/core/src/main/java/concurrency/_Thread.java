package concurrency;

/**
 * По умолчанию именем главного потока будет main.
 *
 * Для управления потоком класс Thread предоставляет еще ряд методов. Наиболее используемые из них:
 *
 * getName(): возвращает имя потока
 *
 * setName(String name): устанавливает имя потока
 *
 * getPriority(): возвращает приоритет потока
 *
 * setPriority(int proirity): устанавливает приоритет потока.
 * Приоритет является одним из ключевых факторов для выбора системой потока из кучи потоков для выполнения.
 * В этот метод в качестве параметра передается числовое значение приоритета - от 1 до 10.
 * По умолчанию главному потоку выставляется средний приоритет - 5.
 *
 * isAlive(): возвращает true, если поток активен
 *
 * isInterrupted(): возвращает true, если поток был прерван
 *
 * join(): ожидает завершение потока
 *
 * run(): определяет точку входа в поток
 *
 * sleep(): приостанавливает поток на заданное количество миллисекунд
 *
 * start(): запускает поток, вызывая его метод run()
 */

public class _Thread extends Thread {

   public _Thread(String name) {
      super(name);
   }

   @Override
   public void run() {
      System.out.println("Starting " + "thread name is: " + this.getName());
   }

   public static void main(String[] args) throws InterruptedException {
      _Thread thread1 = new _Thread("Thread 1");
      System.out.println("Before starting: " + thread1.isAlive());
      thread1.start();
      System.out.println("After starting: " + thread1.isAlive());
      thread1.join();
      System.out.println("After completed: " + thread1.isAlive());
      _Thread thread2 = new _Thread("Thread 2");
      thread2.start();
      _Thread thread3 = new _Thread("Thread 3");
      thread3.start();
   }
}
