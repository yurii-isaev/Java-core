package creational.singleton;

/**
 * Дизайн-паттерн Singleton.
 * <p>
 * Плюсы паттерна Singleton:
 * 1. Гарантированное существование единственного экземпляра:
 * Паттерн Singleton гарантирует, что в системе будет существовать только один экземпляр класса.
 * Это полезно, когда требуется иметь глобальный доступ к объекту из разных частей программы.
 * <p>
 * 2. Удобный доступ к экземпляру:
 * Синглтон предоставляет глобальную точку доступа к своему экземпляру.
 * Это упрощает получение доступа к объекту
 * из любой части программы без необходимости передачи ссылок или создания новых экземпляров.
 * <p>
 * 3. Ленивая инициализация:
 * Синглтон может быть инициализирован только при первом обращении к нему.
 * Это позволяет отложить создание объекта до момента его реального использования,
 * что может быть полезно для оптимизации производительности.
 * <p>
 * 4. Поддержка разделения ресурсов:
 * Синглтон может быть использован для управления доступом к общим ресурсам,
 * таким как база данных или файловая система. Он позволяет гарантировать,
 * что только один поток будет иметь доступ к ресурсу в определенный момент времени.
 * <p>
 * Минусы паттерна Singleton:
 * 1. Затруднение в тестировании:
 * Использование синглтона может затруднить тестирование, особенно при написании модульных тестов.
 * Поскольку синглтон предоставляет глобальный доступ к своему экземпляру,
 * тестирование отдельных компонентов, которые зависят от синглтона, становится сложнее.
 * <p>
 * 2. Нарушение принципа единственной ответственности:
 * Синглтон может накапливать слишком много ответственности,
 * поскольку он предоставляет глобальный доступ к своему экземпляру.
 * Это может привести к нарушению принципа единственной ответственности
 * и усложнить поддержку и изменение кода.
 * <p>
 * 3. Потенциальные проблемы с многопоточностью:
 * Если синглтон используется в многопоточной среде и не синхронизирован правильно,
 * могут возникнуть проблемы с многопоточностью, такие как состояние гонки
 * или неправильное чтение/запись данных.
 * <p>
 * 4. Затруднения при расширении функциональности:
 * Внесение изменений в синглтон может быть затруднительным,
 * особенно если другие компоненты программы жестко зависят от его интерфейса.
 * Это может привести к сложностям при расширении функциональности
 * или замене синглтона другой реализацией.
 */

public class Main {
   public static void main(String[] args) {
      // Получаем экземпляр Singleton
      Singleton singleton = Singleton.getInstance();

      // Вызываем метод объекта
      singleton.doSomething();
   }
}