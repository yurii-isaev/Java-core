package io.sequence;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Stack;

public class SequenceInput {
   Stack<String> files;
   StringBuilder sb = new StringBuilder();

   public SequenceInput(Stack<String> files) {
      this.files = files;
   }

   public void read() throws IOException {
      try (InputStream in = new SequenceInputStream(new SequenceEnumeration(files))) {
         int data;
         while ((data = in.read()) != -1) {
            sb.append((char) data);
         }

         String res = new String(sb);
         System.out.println(res); // Java 2Java 3
      }
   }

   public static void main(String[] args) throws IOException {
      final String path1 = "/Users/Shved/Desktop/test/test_2.txt";
      final String path2 = "/Users/Shved/Desktop/test/test_3.txt";
      Stack<String> stack = new Stack<>();
      stack.add(path1);
      stack.add(path2);
      SequenceInput input = new SequenceInput(stack);
      input.read();
   }
}
