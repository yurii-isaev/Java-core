package structural.decorator;

/**
 * Плюсы паттерна Decorator:
 * 1. Гибкость расширения:
 * Паттерн Decorator позволяет добавлять новую функциональность к объектам динамически,
 * без изменения их основной структуры.
 * Вы можете комбинировать различные декораторы,
 * чтобы получить разные комбинации функциональности.
 * 2. Разделение ответственностей:
 * Decorator разделяет функциональность на отдельные классы,
 * каждый из которых отвечает за конкретный аспект декорирования.
 * Это упрощает поддержку кода и позволяет легко добавлять,
 * удалять или изменять декораторы независимо друг от друга.
 * 3. Сохранение интерфейса:
 * Декораторы реализуют тот же интерфейс,
 * что и декорируемые объекты, поэтому они могут использоваться везде,
 * где ожидается оригинальный объект.
 * Это обеспечивает прозрачность использования и не нарушает принцип подстановки Барбары Лисков.
 * 4. Динамическое добавление и удаление декораторов:
 * Вы можете добавлять и удалять декораторы в любое время, даже во время выполнения программы.
 * Это позволяет динамически изменять поведение объекта без изменения его клиентского кода.
 * <p>
 * Минусы паттерна Decorator:
 * 1. Усложнение структуры кода:
 * Использование декораторов может привести к созданию большого числа классов,
 * особенно если требуется много уровней декорирования.
 * Это может усложнить понимание кода и увеличить его объем.
 * 2. Потеря эффективности:
 * Декораторы добавляют дополнительные уровни индирекции и вызовов методов,
 * что может привести к небольшому снижению производительности.
 * Если вам важна высокая производительность, паттерн Decorator может не быть оптимальным выбором.
 * 3. Необходимость правильного порядка декорирования:
 * Порядок, в котором декораторы применяются к объекту, может быть важным.
 * Неправильный порядок может привести к нежелательным результатам или неправильному поведению объекта.
 * 4. Потенциальное нарушение принципа единственной ответственности:
 * Если каждый декоратор выполняет множество функций,
 * это может привести к нарушению принципа единственной ответственности.
 * Рекомендуется разделять декораторы на отдельные классы,
 * каждый из которых отвечает за конкретный аспект декорирования.
 */

// Step 5: Use the decorators
public class Main {
   public static void main(String[] args) {
      Pizza pizza = new PlainPizza();
      System.out.println("Description: " + pizza.getDescription());
      System.out.println("Cost: $" + pizza.getCost());

      pizza = new CheeseDecorator(pizza);
      System.out.println("Description: " + pizza.getDescription());
      System.out.println("Cost: $" + pizza.getCost());

      pizza = new PepperoniDecorator(pizza);
      System.out.println("Description: " + pizza.getDescription());
      System.out.println("Cost: $" + pizza.getCost());

        /*
        Description: Plain pizza
        Cost: $10.0
        Description: Plain pizza, Cheese
        Cost: $12.0
        Description: Plain pizza, Cheese, Pepperoni
        Cost: $15.0
        */
   }
}