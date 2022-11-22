package broker.easy;

import java.util.Objects;

public class Message {

   private final String data;

   public Message(String data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null) {
         return false;
      }
      if (this.getClass() != object.getClass()) {
         return false;
      }
      Message message = (Message) object;
      return Objects.equals(this.data, message.data);
   }

   @Override
   public int hashCode() {
      return Objects.hash(data);
   }

   @Override
   public String toString() {
      return this.getClass().getName() + "[data = " + this.data + "]";
   }
}
