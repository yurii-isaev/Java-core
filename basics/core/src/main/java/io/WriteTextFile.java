package io;

import java.io.*;
import java.nio.file.Files;

/**
 * Задание:
 * 1. Записать текст в фаил с помощью байтового потока.
 * 2. Перед записей проверить существует ли данная запись в файле.
 * 3. Если запись существует отменить операцию запись в данный файл.
 */

public class WriteTextFile {
   File file = new File("C:/Users/Shved/Desktop/test/test_1.txt");
   String text = "test2";

   private void writeInFile() {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String line;
         while ((line = br.readLine()) != null) {
            if (line.equals(text)) {
               System.out.println("This text already exist in file");
               return;
            }
         }
         try (OutputStream os = Files.newOutputStream(file.toPath());
              BufferedOutputStream bos = new BufferedOutputStream(os)) {
            byte[] data = text.getBytes();
            bos.write(data);
            System.out.println("Writing to file was successful");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // Запись в файл используя символьный поток, который принимает себя байтовый поток
   private void writeFileText() {
      String path = "C:/Users/Shved/Desktop/test/test_1.txt";
      try (Writer writer = new FileWriter(path)) {
         //try (Writer writer = new OutputStreamWriter(Files.newOutputStream(Paths.get(path)), StandardCharsets.UTF_8)) {
         writer.write(text);
         System.out.println("Writing to file was successful");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      WriteTextFile copy = new WriteTextFile();
      copy.writeFileText();
   }
}
