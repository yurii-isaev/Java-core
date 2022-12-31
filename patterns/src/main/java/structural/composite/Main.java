package structural.composite;

/**
 * Плюсы паттерна Composite:
 * 1. Упрощение клиентского кода:
 * Клиентский код может работать с отдельными объектами
 * и составными объектами единообразно через общий интерфейс компонента.
 * Это упрощает код клиента, так как ему не нужно знать о типе конкретного объекта, с которым он работает.
 * 2. Рекурсивная структура:
 * Паттерн Composite позволяет создавать рекурсивные структуры, состоящие из компонентов,
 * которые могут содержать другие компоненты.
 * Это удобно, когда требуется работать с древовидными или иерархическими структурами данных.
 * 3. Гибкость и расширяемость:
 * Паттерн Composite обеспечивает гибкость и расширяемость,
 * позволяя добавлять новые типы компонентов без изменения существующего кода.
 * Новые компоненты могут быть добавлены как листья (leaf),
 * так и составные (composite) объекты, сохраняя единообразие интерфейса.
 * <p>
 * Минусы паттерна Composite:
 * 1. Ограничения в поведении компонентов:
 * Все компоненты в структуре Composite должны реализовывать один и тот же интерфейс.
 * Это означает, что некоторые методы могут быть не применимы для определенных типов компонентов.
 * Например, операции, специфичные для листьев, могут быть не поддерживаемыми в составных объектах.
 * 2. Затраты на управление памятью:
 * Использование структуры Composite может привести к дополнительным затратам на управление памятью.
 * Каждый компонент может содержать ссылки на другие компоненты,
 * что может привести к увеличению объема памяти, особенно если структура является глубокой
 * или содержит большое количество объектов.
 * 3. Сложность при обходе структуры:
 * Обход структуры Composite может быть сложным,
 * особенно если в ней содержатся глубокие вложенности или циклические ссылки.
 * Необходимо аккуратно проектировать итерацию по компонентам,
 * чтобы избежать бесконечных циклов или неправильного обхода.
 */

public class Main {
   public static void main(String[] args) {
      Employee developer1 = new Developer("John Doe", "Senior Developer");
      Employee developer2 = new Developer("Jane Smith", "Junior Developer");

      Manager manager1 = new Manager("Mike Johnson", "Development Manager");
      manager1.addEmployee(developer1);
      manager1.addEmployee(developer2);

      Employee developer3 = new Developer("Mark Davis", "Senior Developer");
      Employee developer4 = new Developer("Sarah Thompson", "Junior Developer");

      Manager manager2 = new Manager("Emily Wilson", "Project Manager");
      manager2.addEmployee(developer3);
      manager2.addEmployee(developer4);

      manager2.addEmployee(manager1);

      manager2.showDetails();

      /*
      Name: Emily Wilson, Position: Project Manager
      Team Members:
      Name: Mark Davis, Position: Senior Developer
      Name: Sarah Thompson, Position: Junior Developer
      Name: Mike Johnson, Position: Development Manager
      Team Members:
      Name: John Doe, Position: Senior Developer
      Name: Jane Smith, Position: Junior Developer
      */
   }
}

