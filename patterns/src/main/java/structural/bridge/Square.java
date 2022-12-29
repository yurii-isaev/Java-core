package structural.bridge;

// Concrete implementation 2
class Square implements Shape {
   private Color color;

   public Square(Color color) {
      this.color = color;
   }

   public void draw() {
      System.out.print("Drawing a square in ");
      color.fill();
   }
}
