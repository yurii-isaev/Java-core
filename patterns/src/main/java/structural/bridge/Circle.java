package structural.bridge;

// Concrete implementation 1
class Circle implements Shape {
   private Color color;

   public Circle(Color color) {
      this.color = color;
   }

   @Override
   public void draw() {
      System.out.print("Drawing a circle in ");
      color.fill();
   }
}
