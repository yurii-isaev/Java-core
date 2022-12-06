package behavioral.chainofresponsibility;

public class OrderConfirmationHandler extends Handler {

   @Override
   public void handleRequest(Request request) {
      System.out.println(request.getProductName() + " item order confirmed");
   }
}
