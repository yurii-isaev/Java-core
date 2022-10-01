package io;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

/**
 * Задание:
 * 1. Создать каталог;
 * 2. Сгенерировать в цикл 10 файлов в каталоге;
 * 3. Вывести на консоль содержимле каталога;
 * 4. Сделать запись в каждый файл: java1, java2, .... и т.д.
 * 5. В цикле найти файл в котором содержится текст: java7.
 */

public class FileGenerator {
   public static void main(String[] args) throws IOException {
      File dir = new File("C:/Users/Shved/Desktop/test");
      dir.mkdir();

      for (int i = 1; i <= 10; i++) {
         File file = new File(dir, "test_" + i + ".txt");
         file.createNewFile();
         try (OutputStream os = Files.newOutputStream(file.toPath());
              BufferedOutputStream bos = new BufferedOutputStream(os)) {
            bos.write(("Java " + i).getBytes());
         }
         catch (IOException e) {
            System.out.println(e);
         }
      }

      for (File file : requireNonNull(dir.listFiles())) {
         System.out.println(file.getName());
         try (FileReader reader = new FileReader(file)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
               if (scan.nextLine().equals("Java 7")) {
                  System.out.println("This file here: " + file.getName());
               }
            }
         }
      }
   }
}
