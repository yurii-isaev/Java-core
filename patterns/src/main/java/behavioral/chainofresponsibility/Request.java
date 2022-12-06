package behavioral.chainofresponsibility;

public class Request {
   private String productName;
   private double amount;

   public Request(String productName, double amount) {
      this.productName = productName;
      this.amount = amount;
   }

   public String getProductName() {
      return productName;
   }

   public double getAmount() {
      return amount;
   }
}
