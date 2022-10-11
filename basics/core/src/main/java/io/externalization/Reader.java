package io.externalization;

import java.io.*;

public class Reader {
   public static String path = "/Users/Shved/Documents/Projects/Java-core/basics/core/src/main/resources/out.dat";

   public static void main(String[] args) throws IOException, ClassNotFoundException {
      testWrite();
      testRead();
   }

   private static void testWrite() throws IOException {
      Second second = new Second();
      second.setFirstCode("FirstCode");
      second.setFirstName("FirstName");
      second.setSecondCode("SecondCode");
      second.setSecondName("SecondName");

      try (FileOutputStream os = new FileOutputStream(path);
           ObjectOutputStream oos = new ObjectOutputStream(os)) {
         oos.writeObject(second);
      }
   }

   private static void testRead() throws IOException, ClassNotFoundException {
      try (FileInputStream fs = new FileInputStream(path);
           ObjectInputStream ois = new ObjectInputStream(fs)) {
         Second second = (Second) ois.readObject();
         System.out.println(second.getFirstCode());
         System.out.println(second.getFirstName());
         System.out.println(second.getSecondCode());
         System.out.println(second.getSecondCode());
      }
   }
}
