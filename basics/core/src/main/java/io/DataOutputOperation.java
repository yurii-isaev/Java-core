package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.*;

public class DataOutputOperation {
   String path = "/Users/Shved/Desktop/test/test_1.txt";

   private void read() throws IOException {
      try (DataOutputStream out = new DataOutputStream(newOutputStream(get(path)));
           DataInputStream in = new DataInputStream(newInputStream(get(path)))) {
         // записываем значения
         out.writeUTF("Test UTF"); // обязательная запись в фаил, иначе исключение
         // считывание из файла
         String data = in.readUTF();
         System.out.println(data);
      }
   }

   private void write() throws IOException {
      try (DataOutputStream out = new DataOutputStream(newOutputStream(get(path)))) {
         out.writeUTF("Hello world");
         out.flush();
      }
   }

   public static void main(String[] args) throws IOException {
      DataOutputOperation operation = new DataOutputOperation();
      operation.write();
      //operation.read();
   }
}
