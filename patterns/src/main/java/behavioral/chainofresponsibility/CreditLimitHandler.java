package behavioral.chainofresponsibility;

public class CreditLimitHandler extends Handler {

   @Override
   public void handleRequest(Request request) {
      if (hasEnoughCredit(request.getAmount())) {
         System.out.println("The buyer has enough funds in the account");
         if (nextHandler != null) {
            nextHandler.handleRequest(request);
         }
      } else {
         System.out.println("Insufficient funds on the buyer's account");
      }
   }

   // Проверка кредитного лимита покупателя
   // Вернуть true, если у покупателя достаточно средств, иначе false
   private boolean hasEnoughCredit(double amount) {
      Stock s = new Stock();
      return amount >= s.getPrice();
   }
}
