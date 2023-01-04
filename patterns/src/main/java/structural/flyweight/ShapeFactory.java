package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight factory
class ShapeFactory {
   private static final Map<String, Shape> circleMap = new HashMap<>();

   public static Shape getCircle(String color) {
      Circle flyweight = (Circle) circleMap.get(color);

      if (flyweight == null) {
         flyweight = new Circle(color);
         circleMap.put(color, flyweight);
         System.out.println("Creating new circle: Color = " + color);
      }

      return flyweight;
   }
}
