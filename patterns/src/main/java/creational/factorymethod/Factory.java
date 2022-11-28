package creational.factorymethod;

public enum Factory {

   CAR {
      @Override
      public Transport createTransport() {
         return new Audi();
      }
   },

   AIRCRAFT {
      @Override
      public Transport createTransport() {
         return new Boeing();
      }
   };

   public abstract Transport createTransport();
}
