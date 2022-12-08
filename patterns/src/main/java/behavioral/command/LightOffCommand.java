package behavioral.command;

// Конкретная команда - выключение света
class LightOffCommand implements Command {
   private final Light light;

   public LightOffCommand(Light light) {
      this.light = light;
   }

   public void execute() {
      light.off();
   }
}
