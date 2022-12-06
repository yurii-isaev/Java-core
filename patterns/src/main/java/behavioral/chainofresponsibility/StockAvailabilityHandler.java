package behavioral.chainofresponsibility;

public class StockAvailabilityHandler extends Handler {

   @Override
   public void handleRequest(Request request) {
      if (isProductAvailable(request.getProductName())) {
         System.out.println("Product " + request.getProductName() + " available in stock");
         if (nextHandler != null) {
            nextHandler.handleRequest(request);
         }
      } else {
         System.out.println("Product " + request.getProductName() + " out of stock");
      }
   }

   // Проверка наличия товара на складе
   // Вернуть true, если товар доступен, иначе false
   private boolean isProductAvailable(String productName) {
      Stock s = new Stock();
      return productName == s.getItem();
   }
}
