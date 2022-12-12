package behavioral.iterator;

import java.util.List;

// Concrete iterator class
class MyIterator<T> implements Iterator<T> {
   private List<T> elements;
   private int position;

   public MyIterator(List<T> elements) {
      this.elements = elements;
      this.position = 0;
   }

   public boolean hasNext() {
      return position < elements.size();
   }

   public T next() {
      if (hasNext()) {
         T element = elements.get(position);
         position++;
         return element;
      }
      return null;
   }

   public void remove() {
      if (position > 0) {
         elements.remove(position - 1);
         position--;
      }
   }
}
