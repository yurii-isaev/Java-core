package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * Задание:
 * 1. Создать фаил только в единственном числе.
 * 2. Записать текст в новый фаил.
 * 3. Если запись существует отменить операцию запись в данный файл.
 */

public class CreateTextFile {

   private void createRandomAccessFile() {
      String text = "Test";
      File file = new File("C:/Users/Shved/Desktop/test/test_14.txt");
      try (RandomAccessFile rand = new RandomAccessFile(file, "rw")) {
         rand.write(text.getBytes(StandardCharsets.UTF_8));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      CreateTextFile file = new CreateTextFile();
      file.createRandomAccessFile();
   }
}
