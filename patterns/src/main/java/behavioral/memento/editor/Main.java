package behavioral.memento.editor;

/**
 * Плюсы паттерна Memento на Java:
 * 1. Восстановление состояния:
 * Паттерн Memento позволяет сохранять и восстанавливать состояние объекта.
 * Это полезно, когда вам нужно сохранить промежуточное состояние объекта
 * и восстановить его позже, например, при отмене операции.
 * 2. Изолированность состояния:
 * Memento обеспечивает изолированность состояния объекта.
 * Состояние объекта хранится внутри объекта Memento
 * и не доступно другим объектам. Это помогает поддерживать принцип инкапсуляции
 * и предотвращает неправильное изменение состояния объекта.
 * 3. Простота использования:
 * Паттерн Memento прост в использовании на Java. Он предоставляет методы для сохранения
 * и восстановления состояния объекта,
 * что делает его удобным в применении.
 * <p>
 * Минусы паттерна Memento на Java:
 * 1. Потребление памяти:
 * Если объект, состояние которого нужно сохранить,
 * имеет большой объем данных,
 * то хранение всех состояний может потребовать значительного объема памяти.
 * Это особенно важно учитывать при работе с большими объектами
 * или при хранении большого количества состояний.
 * 2. Нарушение инкапсуляции:
 * В некоторых случаях использование паттерна может привести к нарушению принципа инкапсуляции.
 * Если состояние объекта, которое нужно сохранить, содержит приватные данные,
 * то для доступа к этим данным из объекта Memento может потребоваться нарушение инкапсуляции.
 * 3. Ограничения восстановления:
 * Паттерн Memento сохраняет состояние объекта в определенный момент времени.
 * Если вам нужно восстановить состояние объекта на более раннюю точку во времени,
 * это может быть затруднительно или невозможно с использованием паттерна Memento.
 */

// Client class
public class Main {
   public static void main(String[] args) {
      TextEditor textEditor = new TextEditor();
      History history = new History();

      // Append some text
      textEditor.appendText("Hello, ");
      System.out.println("Current content: " + textEditor.getContent());

      // Save the state
      history.push(textEditor.save());

      // Append more text
      textEditor.appendText("world!");
      System.out.println("Current content: " + textEditor.getContent());

      // Restore the previous state
      Memento memento = history.pop();
      if (memento != null) {
         textEditor.restore(memento);
         System.out.println("Restored content: " + textEditor.getContent());
      }

       /*
      Output:
      Current content: Hello,
      Current content: Hello, world!
      Restored content: Hello,
      */
   }
}
