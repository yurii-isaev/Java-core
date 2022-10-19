package stream;

import java.util.Objects;

public class People {
   private String name;
   private int age;
   private Gender gender;

   public People(String name, int age, Gender gender) {
      this.name = name;
      this.age = age;
      this.gender = gender;
   }

   @Override
   public String toString() {
      return
          "People{"   +
          "name='"    + name +
          ", age="    + age +
          ", gender=" + gender +
          '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      People people = (People) o;
      return age == people.age && name.equals(people.name) && gender == people.gender;
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, age, gender);
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public Gender getGender() {
      return gender;
   }
}
