package behavioral.chainofresponsibility;

public class Stock {
   private final String item;
   private final int price;

   public Stock() {
      this.price = 25;
      this.item = "Book";
   }

   public String getItem() {
      return item;
   }

   public int getPrice() {
      return price;
   }
}
