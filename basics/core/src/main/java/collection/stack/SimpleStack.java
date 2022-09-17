package collection.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Внутри наших методов вызываются методы класса Stack:
 * <p>
 * push() — добавляет элемент на верх стека.
 * <p>
 * pop() — удаляет верхний элемент из стека и возвращает его.
 * <p>
 * peek() — возвращает верхний элемент стека, но не удаляет его из стека.
 * <p>
 *
 * @param <T>
 */
public class SimpleStack<T> implements Stack<T> {
   private List<T> list = new ArrayList<>();

   @Override
   public void push(T item) {
      list.add(0, item);
   }

   @Override
   public T pop() {
      return list.remove(0);
   }

   @Override
   public boolean isEmpty() {
      return list.isEmpty();
   }

   public boolean contains(T item) {
      return list.contains(item);
   }
}
