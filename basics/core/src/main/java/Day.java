public enum Day {
   MONDAY(true, 8),
   TUESDAY(true, 8),
   WEDNESDAY(true, 8),
   THURSDAY(true, 8),
   FRIDAY(true, 8),
   SATURDAY(false, 0),
   SUNDAY(false, 0);

   private final boolean isWorkingDay;
   private final int workingHour;

   Day(boolean isWorkingDay, int workingHour) {
      this.isWorkingDay = isWorkingDay;
      this.workingHour = workingHour;
   }

   public static void main(String[] args) {
      for (Day day : Day.values()) {
         System.out.println(day.name() + " " + day.isWorkingDay + " " + day.workingHour);
      }
   }

   public static class Pair<K, V> {
      private final K key;
      private final V value;

      public Pair(K key, V value) {
         this.key = key;
         this.value = value;
      }

      public static void main(String[] args) {
         Pair<Day, Integer>[] scheduler = new Pair[4];
         scheduler[0] = new Pair<>(Day.MONDAY, 4);
         scheduler[1] = new Pair<>(Day.TUESDAY, 4);
         scheduler[2] = new Pair<>(Day.FRIDAY, 2);
         scheduler[3] = new Pair<>(Day.SATURDAY, 0);

         for (Pair p : scheduler) {
            System.out.println(p.key +
                " worked: " + p.value +
                " hours norm: " + ((Day) p.key).workingHour);
         }
      }
   }
}
