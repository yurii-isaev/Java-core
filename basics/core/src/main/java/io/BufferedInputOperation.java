package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.*;

public class BufferedInputOperation {
   StringBuilder sb = new StringBuilder();

   private void read() throws IOException {
      String path = "/Users/Shved/Desktop/test/test_1.txt";
      try (BufferedInputStream in = new BufferedInputStream(newInputStream(get(path)))) {
         byte[] data = new byte[1024];
         int amountData = in.read(data, 0, 1024);
         // while (amountData != -1 && amountData == 1024) {
         while (amountData == 1024) {
            sb.append(new String(data, StandardCharsets.UTF_8));
            amountData = in.read(data, 0, 1024);
         }
         if (amountData != -1) {
            byte[] reside = new byte[amountData];
            System.arraycopy(data, 0, reside, 0, reside.length);
            sb.append(new String(reside, StandardCharsets.UTF_8));
         }
         System.out.println(sb);
      }
   }

   private void copy() throws IOException {
      String pathFrom = "/Users/Shved/Desktop/test/test_1.txt";
      String pathTo = "/Users/Shved/Desktop/test/test_15.txt";
      int bufferSize = 1024 * 8;
      int indexStartReading = 0;
      try (BufferedInputStream in = new BufferedInputStream(newInputStream(get(pathFrom)))) {
         BufferedOutputStream out = new BufferedOutputStream(newOutputStream(get(pathTo)));
         byte[] buf = new byte[bufferSize];
         int dataLength = in.read(buf, indexStartReading, bufferSize);
         while (dataLength != -1) {
            out.write(buf, 0, dataLength);
            out.flush();
            dataLength = in.read(buf, indexStartReading, bufferSize);
         }
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedInputOperation operation = new BufferedInputOperation();
      // operation.read();
      operation.copy();
   }
}
