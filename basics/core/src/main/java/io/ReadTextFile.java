package io;

import java.io.*;
import java.nio.file.Files;

/**
 * Задание:
 * 1. Прочитать текст из уже созданного файла, используя байтовый поток;
 * 2. Прочитать текст из уже созданного файла, используя символьный поток;
 * 3. Прочитать текст из массива символов, используя символьный поток;
 */

public class ReadTextFile {
   StringBuilder sb = new StringBuilder();

   // Чтение из файла используя байтовый поток
   private void readFile() {
      File file = new File("C:/Users/Shved/Desktop/test/test_1.txt");
      try (InputStream in = Files.newInputStream(file.toPath())) {
         int data = in.read();
         while (data != -1) {
            sb.append((char) data);
            data = in.read();
         }
         // text = new String(sb);
         System.out.println(sb); // вывод текста в консоль
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // Чтение из файла используя символьный поток, который принимает себя байтовый поток
   private void readFileText() {
      String path = "C:/Users/Shved/Desktop/test/test_1.txt";
      try (Reader reader = new FileReader(path)) {
         //try (Reader reader = new InputStreamReader(Files.newInputStream(Paths.get(path)), StandardCharsets.UTF_8)) {
         int data = reader.read();
         while (data != -1) {
            sb.append((char) data);
            data = reader.read();
         }
         System.out.println(sb); // вывод текста в консоль
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // Чтение из файла используя символьный поток, который принимает себя байтовый поток
   private void readFileChar() {
      char[] path = new char[]{'a', 'b', 'c'};
      try (Reader reader = new CharArrayReader(path)) {
         int data = reader.read();
         while (data != -1) {
            sb.append((char) data);
            data = reader.read();
         }
         System.out.println(sb); // вывод текста в консоль -> abc

      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public static void main(String[] args) {
      ReadTextFile file = new ReadTextFile();
      file.readFileText();
   }
}
