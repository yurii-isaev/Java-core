package io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamOperation {
   private static final String filename = "/Users/Shved/Desktop/test/test_1.txt";

   public static void main(String[] args) {
      // создадим список объектов, которые будем записывать
      List<Person> people = new ArrayList<>();
      people.add(new Person("Tom", 30, 80.5, false));
      people.add(new Person("Sam", 33, 77.8, true));

      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
         oos.writeObject(people);
         System.out.println("File has been written");
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
      }

      // десериализация в новый список
      List<Person> newPeople = new ArrayList<>();
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
         newPeople = (List<Person>) ois.readObject();
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
      }

      newPeople.forEach(p -> System.out.printf("Name: %s \t Age: %d \t Height: %f \t Married %b \n",
          p.getName(), p.getAge(), p.getHeight(), p.getMarried())
          // Name: Tom 	 Age: 30 	 Height: 80,500000 	 Married false
          // Name: Sam 	 Age: 33 	 Height: 77,800000 	 Married false
      );
   }
}
