package stream;

import java.util.Comparator;

public class PeopleAgeComparator implements Comparator<People> {

   @Override
   public int compare(People o1, People o2) {
      return o1.getAge() - o2.getAge();
   }
}
