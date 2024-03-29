package creational.builder;

/**
 * Дизайн-паттерн Builder (Строитель) решает проблему создания сложных объектов
 * с большим числом параметров или настраиваемых свойств.
 * Он предоставляет гибкое решение для пошагового создания объектов,
 * позволяя управлять процессом конструирования и создавать объекты с различными конфигурациями.
 * <p>
 * Основная проблема, которую решает паттерн Builder,
 * заключается в том, что при создании объектов с большим количеством параметров или настраиваемых свойств,
 * конструкторы могут становиться громоздкими и сложными для понимания.
 * Кроме того, если у объекта есть множество необязательных параметров,
 * использование конструктора с множеством перегруженных вариантов может стать неудобным и запутанным.
 * <p>
 * Паттерн Builder предлагает разделить процесс создания объекта на несколько шагов.
 * Он включает в себя создание отдельного строителя (Builder),
 * который отвечает за пошаговое конструирование объекта.
 * Строитель содержит методы для установки значений параметров объекта,
 * а также метод для фактического создания объекта.
 * Таким образом, клиентский код может последовательно вызывать методы строителя для настройки объекта пошагово.
 * <p>
 * Преимущества использования паттерна Builder включают:
 * 1. Упрощение процесса создания объектов с большим количеством параметров или настраиваемых свойств.
 * 2. Улучшение читаемости кода и уменьшение сложности конструкторов.
 * 3. Позволяет создавать объекты с различными конфигурациями, не создавая множество перегруженных конструкторов.
 * 4. Позволяет создавать неизменяемые (immutable) объекты,
 * так как объект может быть полностью сконфигурирован перед его созданием.
 * 5. Применение паттерна Builder особенно полезно, когда объект имеет множество настраиваемых параметров
 * или когда порядок установки параметров важен.
 * Он также может быть полезен, когда вы хотите создать объект,
 * который должен быть неизменным (immutable) после создания,
 * чтобы обеспечить безопасность потоков или предотвратить нежелательные изменения.
 */

public class Main {
   public static void main(String[] args) {
      Model buy = buy();
      System.out.println(buy.toString());
      System.out.println(buy.getOwner());
      System.out.println(buy.getStsNumber());
      System.out.println(buy.getYear());
   }

   public static Model buy() {
      return Model.builder() // director
          .owner("Test")
          .stsNumber("123 2323")
          .year(2022)
          .build();
   }
}
