package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Java Stream API предлагает два вида методов:
 * 1. Конвейрные (промежуточные) - возвращают другой stream, т.е. трансформуруют текущей поток;
 * 2. Терминальные - возвращают конкретный результат: примитив, объектб, коллекция и т.д.
 */

public class StreamSample {
   public static void main(String[] args) {
      long res = Stream
          .of("a1", "a2", "a3")
          .filter(a -> a.equals("a1"))
          .count();
      out.println(res); // 1

      List list = Arrays.asList("a1", "a2", "a3", "a1");

      out.println(list.stream()
          .filter("a1"::equals)
          .count()); // 2

      out.println(list.stream()
          .findFirst()
          .orElse("0"));  // a1

      out.println(list.stream()
          .skip(list.size() - 1)
          .findFirst()
          .orElse("Empty")); // a1

      out.println(list.stream()
          .filter("a3"::equals)
          .findFirst()
          .get()); // a3

      out.println(list.stream()
          .skip(3)
          .findFirst()
          .get()); // a1

      out.println(list.stream()
          .skip(1)
          .limit(2)
          .collect(Collectors.toList())); // [a2, a3]

      List<People> peopleList = Arrays.asList(
          new People("Vasya", 16, Gender.MAN),
          new People("Vanya", 16, Gender.MAN),
          new People("Petya", 23, Gender.MAN),
          new People("Ivan",  29, Gender.MAN),
          new People("Elena", 50, Gender.WOMAN),
          new People("Olga",  18, Gender.WOMAN),
          new People("Maria", 41, Gender.WOMAN)
      );

      // Найти всех мужчин возраста от 18 до 27 лет
      List<People> age = peopleList.stream()
          .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getGender() == Gender.MAN)
          .collect(Collectors.toList());
      age.forEach(p -> out.println(p));

      // Найти средний возраст среди мужчин
      double averageAge = peopleList.stream()
          .filter(p -> p.getGender() == Gender.MAN)
          .mapToInt(People::getAge)
          .average()
          .getAsDouble();
      out.printf("Number of men age: %d \n", (int) averageAge);

      // Найти количество людей возраста (от 18-55 женщины, 18-60 мужчины)
      List<People> work = peopleList.stream()
          .filter(p -> p.getAge() >= 18)
          .filter(p ->
              (p.getGender() == Gender.MAN && p.getAge() < 60) ||
              (p.getGender() == Gender.WOMAN && p.getAge() < 55))
          .collect(Collectors.toList());
      work.forEach(p -> out.println(p));
      out.printf("\n");

      // Отсортировать список по возрасту и по имени
      peopleList.stream()
          .sorted(Comparator.comparing(People::getName))
          .sorted(Comparator.comparingInt(People::getAge))
          .forEach(out::println);
      //People{name='Vanya', age=16, gender=MAN}
      //People{name='Vasya', age=16, gender=MAN}
      //People{name='Olga',  age=18, gender=WOMAN}
      //People{name='Petya', age=23, gender=MAN}
      //People{name='Ivan',  age=29, gender=MAN}
      //People{name='Maria', age=41, gender=WOMAN}
      //People{name='Elena', age=50, gender=WOMAN}
   }
}
