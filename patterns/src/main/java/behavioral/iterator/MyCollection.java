package behavioral.iterator;

import java.util.*;

// Concrete aggregate class
class MyCollection<T> implements Aggregate<T> {
   private List<T> elements;

   public MyCollection() {
      this.elements = new ArrayList<>();
   }

   public void add(T element) {
      elements.add(element);
   }

   public Iterator<T> createIterator() {
      return new MyIterator<>(elements);
   }
}
