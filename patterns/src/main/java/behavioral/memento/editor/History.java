package behavioral.memento.editor;

import java.util.*;

// Caretaker class
class History {
   private final List<Memento> mementos;

   public History() {
      this.mementos = new ArrayList<>();
   }

   public void push(Memento memento) {
      mementos.add(memento);
   }

   public Memento pop() {
      if (!mementos.isEmpty()) {
         int lastIndex = mementos.size() - 1;
         Memento memento = mementos.get(lastIndex);
         mementos.remove(lastIndex);
         return memento;
      }
      return null;
   }
}
