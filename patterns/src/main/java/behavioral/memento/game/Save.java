package behavioral.memento.game;

public class Save {
   private String level;
   private int time;

   public Save(String level, int time) {
      this.level = level;
      this.time = time;
   }

   public String getLevel() {
      return level;
   }

   public int getTime() {
      return time;
   }
}
