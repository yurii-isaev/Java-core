package behavioral.memento.editor;

// Memento class
class Memento {
   private final String state;

   public Memento(String state) {
      this.state = state;
   }

   public String getState() {
      return state;
   }
}
