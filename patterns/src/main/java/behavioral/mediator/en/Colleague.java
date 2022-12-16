package behavioral.mediator.en;

public enum Colleague {
   ADMIN("Ivan"),
   PETR,
   VLAD,
   ALEX;

   private String stringValue;

   Colleague(String value) {
      this.stringValue = value;
   }

   Colleague() {
   }

   public String value() {
      return stringValue;
   }
}
