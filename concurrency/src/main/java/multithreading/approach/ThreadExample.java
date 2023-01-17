package multithreading.approach;

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

public class ThreadExample extends Thread {

   public ThreadExample(String name) {
      super(name);
   }

   @Override
   public void run() {
      System.out.println("Starting " + "thread name is: " + this.getName());
   }

   public static void main(String[] args) throws InterruptedException {
      ThreadExample thread1 = new ThreadExample("Thread 1");
      System.out.println("Before starting: " + thread1.isAlive());
      thread1.start();
      System.out.println("After starting: " + thread1.isAlive());
      thread1.join();
      System.out.println("After completed: " + thread1.isAlive());
      ThreadExample thread2 = new ThreadExample("Thread 2");
      thread2.start();
      ThreadExample thread3 = new ThreadExample("Thread 3");
      thread3.start();
   }
}
