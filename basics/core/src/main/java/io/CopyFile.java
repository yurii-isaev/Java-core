package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Задание:
 * 1. Скопировать имеющийся фаил test_1.txt в новый фаил с названием target_1.txt;
 * 2. Вырезать имеющийся фаил test_1.txt в новый фаил с названием target_2.txt;
 */

public class CopyFile {
   private boolean copy() {
      File file = new File("C:/Users/Shved/Desktop/test/test_1.txt");
      File target = new File("C:/Users/Shved/Desktop/test/target_1.txt");
      try {
         Files.copy(file.toPath(), target.toPath());
         System.out.println("File coped is successfully");
      } catch (IOException e) {
         System.out.println("File target_1.txt already exist");
      }
      return false;
   }

   private boolean cut() {
      File file = new File("C:/Users/Shved/Desktop/test/test_1.txt");
      File target = new File("C:/Users/Shved/Desktop/test/target_2.txt");
      try {
         Files.move(file.toPath(), target.toPath());
         System.out.println("File cut is successfully");
      } catch (IOException e) {
         System.out.println("File target_2.txt already exist");
      }
      return false;
   }

   public static void main(String[] args) {
      CopyFile copy = new CopyFile();
      copy.copy();
      copy.cut();
   }
}
