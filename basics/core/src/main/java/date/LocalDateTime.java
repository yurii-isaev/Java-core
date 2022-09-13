package date;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.lang.System.*;

/**
 * Класс LocalDate
 * Объекты этого класса не изменяются после создания (класс LocalDate immutable).
 * Являются потокобезопасными.
 * Формат: yyyy-MM-dd.
 * <p/>
 * Класс LocalTime
 * Объекты этого класса не изменяются после создания (класс LocalTime immutable).
 * Являются потокобезопасными.
 * В качестве параметров принимает часы, минуты, секунды.
 * Формат: hh:mm:ss.zzz.
 * <p/>
 * Класс LocalDateTime
 * Объекты этого класса не изменяются после создания (класс LocalTime immutable).
 * Являются потокобезопасными.
 * Формат: yyyy-MM-dd-HH-mm-ss.zzz.
 */
public class LocalDateTime {
   public static void main(String[] args) {
      LocalDate today = LocalDate.now();
      out.println(today); // date now

      LocalDate specificDate1 = LocalDate.of(2017, Month.JULY, 30);
      out.println(specificDate1); // 2017-07-30

      LocalDate epocDate = LocalDate.ofEpochDay(3);
      out.println(epocDate); // date from unix-date

      LocalDate specificDate2 = LocalDate.ofYearDay(2017, 224);
      out.println(specificDate2); // 2017-08-12

      LocalTime time = LocalTime.now();
      out.println(time); // 19:08:41.600697200

      LocalTime specificTime = LocalTime.of(23, 3, 11);
      out.println(specificTime); // 23:03:11

      LocalTime epocTime = LocalTime.ofSecondOfDay(20000);
      out.println(epocTime); // 05:33:20 from unix-date-time

      java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
      out.println(dateTime); // 2022-09-10T19:22:37.862297800

      dateTime = java.time.LocalDateTime.of(LocalDate.now(), LocalTime.now());
      out.println(dateTime); // 2022-09-10T19:22:37.862297800

      ZoneId zone1 = ZoneId.of("Asia/Kolkata");
      LocalTime time1 = LocalTime.now(zone1);
      out.println("India time zone: " + time1);

      ZoneId zone2 = ZoneId.of("Asia/Tokyo");
      LocalTime time2 = LocalTime.now(zone2);
      out.println("Japan time zone: " + time2);

      // Форматирование даты
      out.println(dateTime.format(DateTimeFormatter.ofPattern("d:MM:uuuu"))); // 10:09:2022
      out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));         // 2022-09-10
      out.println(dateTime.format(DateTimeFormatter.ofPattern("d:MM:uuuu HH:mm:ss"))); // 10:09:2022 23:48:52

      // Instant - используется для работы с датой в стандартном представлении и для передачи данных
      Instant timestamp = Instant.now();
      out.println("standard format: " + timestamp); // 2022-09-10T23:48:52.320705300Z

      // Найти разницу в днях между датами
      out.println(specificDate1.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"))); // 30-07-2017
      out.println(specificDate2.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"))); // 12-08-2017

      out.println(specificDate2.minusDays(specificDate1.getDayOfYear()).getDayOfYear()); // 13
   }
}
