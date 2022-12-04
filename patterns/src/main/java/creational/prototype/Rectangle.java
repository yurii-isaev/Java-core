package creational.prototype;

class Rectangle implements Cloneable {
   private int width;
   private int height;

   public Rectangle(int width, int height) {
      this.width = width;
      this.height = height;
   }

   // Метод для установки размеров прямоугольника
   public void setSize(int width, int height) {
      this.width = width;
      this.height = height;
   }

   // Метод для получения информации о прямоугольнике
   public void getInfo() {
      System.out.println("Rectangle width " + width + " and height " + height);
   }

   // Переопределение метода clone() для создания копии объекта
   @Override
   public Rectangle clone() throws CloneNotSupportedException {
      return (Rectangle) super.clone();
   }
}
