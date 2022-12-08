package behavioral.command;

import java.util.*;

// Отправитель команды
class RemoteControl {
   private List<Command> commands;

   RemoteControl() {
      commands = new ArrayList<>();
   }

   void setCommand(Command command) {
      commands.add(command);
   }

   void executeCommands() {
      for (Command command : commands) {
         command.execute();
      }
      commands.clear();
   }
}
