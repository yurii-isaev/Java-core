package behavioral.memento.editor;

// Originator class
class TextEditor {
   private StringBuilder content;

   public TextEditor() {
      this.content = new StringBuilder();
   }

   public void appendText(String text) {
      content.append(text);
   }

   public String getContent() {
      return content.toString();
   }

   public Memento save() {
      return new Memento(content.toString());
   }

   public void restore(Memento memento) {
      content = new StringBuilder(memento.getState());
   }
}
