package structural.adapter.mediaplayer;

/**
 * Плюсы паттерна Adapter:
 * 1. Увеличение повторного использования кода:
 * Паттерн позволяет использовать существующий класс с несовместимым интерфейсом, обернув его в адаптер.
 * Это позволяет повторно использовать существующий код без необходимости его изменения.
 * 2. Гибкость и расширяемость:
 * Адаптер позволяет добавлять новые адаптированные классы без изменения клиентского кода.
 * Это обеспечивает гибкость и расширяемость системы,
 * позволяя легко добавлять поддержку новых классов и интерфейсов.
 * 3. Разделение ответственностей:
 * Адаптер разделяет ответственности между адаптированным классом и клиентским кодом.
 * Клиентский код работает с адаптером, не зная о деталях реализации адаптированного класса.
 * Это помогает разделить логику и упрощает понимание и поддержку кода.
 * <p>
 * Минусы паттерна Adapter:
 * 1. Усложнение кода:
 * Использование паттерна может усложнить код из-за введения дополнительного уровня абстракции.
 * Это может привести к увеличению сложности понимания и поддержки кода.
 * 2. Дополнительные затраты на память и производительность:
 * Адаптер создает дополнительный объект,
 * что может привести к дополнительным затратам на память и производительность.
 * В некоторых случаях это может быть незначительным, но в других случаях может иметь значение.
 * 3. Необходимость создания специфических адаптеров:
 * Для каждого несовместимого класса или интерфейса требуется создание отдельного адаптера.
 * Это может привести к созданию большого количества адаптеров в системе,
 * что может усложнить ее структуру и поддержку.
 */

public class Main {
   public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();
      audioPlayer.play("mp3", "song.mp3");
      audioPlayer.play("vlc", "movie.vlc");
      audioPlayer.play("mp4", "video.mp4");
      audioPlayer.play("avi", "video.avi");

      /*
      Playing mp3 file: song.mp3
      Playing vlc file: movie.vlc
      Playing mp4 file: video.mp4
      Invalid media type: avi. Cannot play file: video.avi
      */
   }
}