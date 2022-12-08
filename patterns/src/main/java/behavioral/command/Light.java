package behavioral.command;

// Получатель команды - свет
public class Light {
   public void on() {
      System.out.println("The light is on");
   }

   public void off() {
      System.out.println("The lights are turned off");
   }
}
