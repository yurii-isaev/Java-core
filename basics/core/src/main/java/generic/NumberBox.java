package generic;

public class NumberBox <T extends Number>{
   T num;

   public NumberBox(T number) {
      this.num = number;
   }

   // Проверить равенство абсолютных значений двух объектов
   boolean absEqual(NumberBox<?> obj) {
      return Math.abs(num.doubleValue()) == Math.abs(obj.num.doubleValue());
   }

   void printInt (NumberBox<? super Double> value) {
      System.out.println(value.getClass());
   }

   public static void main(String[] args) {
      NumberBox<Integer> numBox1 = new NumberBox(1);
      NumberBox<Double> numBox2 = new NumberBox(201.1);
      System.out.println(numBox2.absEqual(numBox1));
      numBox1.printInt(numBox2); // Only Double
   }
}
