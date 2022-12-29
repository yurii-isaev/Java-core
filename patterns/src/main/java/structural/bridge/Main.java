package structural.bridge;

// adapter == bridge
public class Main {
   public static void main(String[] args) {
      Shape circle = new Circle(new RedColor());
      circle.draw();

      Shape square = new Square(new BlueColor());
      square.draw();

      /*
      Drawing a circle in red color
      Drawing a square in blue color
      */
   }
}
