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
   static final File file = new File("/Users/Shved/Desktop/test/test_1.txt");
   static final File target = new File("/Users/Shved/Desktop/test/target_1.txt");

   private void copy() {
      try {
         Files.copy(file.toPath(), target.toPath());
         System.out.println("File coped is successfully");
      } catch (IOException e) {
         System.out.println("File target_1.txt already exist");
      }
   }

   private void cut() {
      try {
         Files.move(file.toPath(), target.toPath());
         System.out.println("File cut is successfully");
      } catch (IOException e) {
         System.out.println("File target_2.txt already exist");
      }
   }

   public static void main(String[] args) {
      CopyFile copy = new CopyFile();
      copy.copy();
      copy.cut();
   }
}
