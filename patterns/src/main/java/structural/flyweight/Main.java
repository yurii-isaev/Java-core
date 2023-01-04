package structural.flyweight;

// Client code
public class Main {
   private static final String[] colors = { "Red", "Green", "Blue", "Yellow", "Black" };

   public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
         Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
         circle.setX(getRandomX());
         circle.setY(getRandomY());
         circle.setRadius(100);
         circle.draw();
      }
   }

   private static String getRandomColor() {
      return colors[(int) (Math.random() * colors.length)];
   }

   private static int getRandomX() {
      return (int) (Math.random() * 100);
   }

   private static int getRandomY() {
      return (int) (Math.random() * 100);
   }

   /*
   Creating new circle: Color = Green
   Drawing Circle: Color = Green, x = 82, y = 26, radius = 100
   Creating new circle: Color = Red
   Drawing Circle: Color = Red, x = 12, y = 4, radius = 100
   Creating new circle: Color = Black
   Drawing Circle: Color = Black, x = 37, y = 67, radius = 100
   Drawing Circle: Color = Green, x = 27, y = 26, radius = 100
   Creating new circle: Color = Yellow
   Drawing Circle: Color = Yellow, x = 86, y = 96, radius = 100
   Drawing Circle: Color = Red, x = 47, y = 11, radius = 100
   Drawing Circle: Color = Black, x = 49, y = 56, radius = 100
   Drawing Circle: Color = Yellow, x = 52, y = 29, radius = 100
   Drawing Circle: Color = Yellow, x = 99, y = 23, radius = 100
   Creating new circle: Color = Blue
   Drawing Circle: Color = Blue, x = 58, y = 67, radius = 100
   */
}
