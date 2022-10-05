package io.sequence;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SequenceStreamOperation {
   private static final String path1 = "/Users/Shved/Desktop/test/test_1.txt";
   private static final String path2 = "/Users/Shved/Desktop/test/test_2.txt";

   public static void inputStream() throws IOException {
      InputStream is1 = new FileInputStream(path1);
      InputStream is2 = new FileInputStream(path2);

      // Create SequenceInputStream:
      InputStream is = new SequenceInputStream(is1, is2);
      InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
      BufferedReader buf = new BufferedReader(isr);

      buf.lines().forEach(System.out::println);
      buf.close();
   }

   public static void main(String[] args) throws IOException {
      inputStream();
   }
}
