package io.sequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Stack;

public class SequenceEnumeration implements Enumeration<FileInputStream> {
   private final Enumeration<String> files;

   public SequenceEnumeration(Stack<String> files) {
      this.files = files.elements();
   }

   // проверка на существование элементов
   @Override
   public boolean hasMoreElements() {
      return files.hasMoreElements();
   }

   // возвращает существующий элемент
   @Override
   public FileInputStream nextElement() {
      try {
         return new FileInputStream(files.nextElement());
      } catch (FileNotFoundException e) {
         return null;
      }
   }
}
