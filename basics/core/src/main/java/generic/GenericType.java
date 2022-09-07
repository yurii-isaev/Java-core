package generic;

public class GenericType {

   public static class Box {
      private Object item;

      public Object getItem() {
         return item;
      }

      public void setItem(Object item) {
         this.item = item;
      }

      public static void main(String[] args) {
         Box box = new Box();
         box.setItem("5");
         Object item = box.getItem();
         System.out.println(item);

         int boxItem = (int) box.getItem();
         System.out.println(boxItem); // -> ClassCastException
      }
   }

   public static class GenericBox<T> {
      private T item;

      public T getItem() {
         return item;
      }

      public void setItem(T item) {
         this.item = item;
      }

      public static void main(String[] args) {
         GenericBox<Integer> box = new GenericBox();
         box.setItem(5);
         Integer item = box.getItem();
         System.out.println(item);
         // !! Generics работает только со ссылочными типами данных и не работает с примитивами !!
      }
   }
}
