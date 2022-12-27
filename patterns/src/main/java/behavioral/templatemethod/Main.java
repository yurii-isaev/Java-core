package behavioral.templatemethod;

/**
 * Плюсы паттерна Template Method на Java:
 * 1. Повторное использование кода:
 * Паттерн Template Method позволяет вынести общую структуру алгоритма
 * в базовый класс и определить в нем шаги,
 * которые должны быть выполнены в определенном порядке.
 * Подклассы могут переопределить только необходимые шаги, сохраняя общую структуру.
 * Это позволяет повторно использовать код и избегать дублирования.
 * 2. Гибкость:
 * Шаблонный метод позволяет изменять или расширять поведение алгоритма,
 * переопределяя отдельные шаги в подклассах.
 * Это обеспечивает гибкость в настройке и адаптации алгоритма
 * под различные ситуации без изменения его общей структуры.
 * 3. Расширяемость:
 * Паттерн Template Method позволяет легко добавлять новые подклассы,
 * которые реализуют свои собственные специфичные шаги алгоритма.
 * Это обеспечивает расширяемость и возможность добавления нового функционала без изменения существующего кода.
 *
 * Минусы паттерна Template Method на Java:
 * 1. Ограничение гибкости:
 * Паттерн Template Method определяет общую структуру алгоритма,
 * и подклассы могут переопределить только отдельные шаги.
 * Это может ограничить возможности изменения алгоритма в более глубоком смысле.
 * Если требуется большая гибкость и динамическое изменение алгоритма, возможно,
 * понадобится другой паттерн, например, Стратегия (Strategy).
 * 2. Нарушение инкапсуляции:
 * Подклассы, переопределяющие шаги алгоритма,
 * могут получить доступ к защищенным методам базового класса.
 * Это нарушает принцип инкапсуляции,
 * так как базовый класс должен предоставить доступ к своим внутренним деталям подклассам.
 * Это может сделать код более сложным и менее безопасным.
 * 3. Зависимость от иерархии классов:
 * Паттерн Template Method требует наличия иерархии классов,
 * где базовый класс определяет общую структуру алгоритма, а подклассы переопределяют отдельные шаги.
 * Если иерархия классов не предусмотрена или неудобна для использования,
 * паттерн может быть неэффективным или трудным в реализации.
 */

public class Main {
   public static void main(String[] args) {
      Game game = new Football();
      game.play();
      System.out.println();

      game = new Cricket();
      game.play();

      /*
      Football Game Initialized! Start playing.
      Football Game Started. Enjoy the game!
      Football Game Finished!

      Cricket Game Initialized! Start playing.
      Cricket Game Started. Enjoy the game!
      Cricket Game Finished!
      */
   }
}