package behavioral.command;

// Конкретная команда - включение света
class LightOnCommand implements Command {
   private final Light light;

   public LightOnCommand(Light light) {
      this.light = light;
   }

   public void execute() {
      light.on();
   }
}
