package behavioral.memento.game;

public class Game {
   private String level;
   private int time;

   // Игра содержит
   public void set(String level, int time) {
      this.level = level;
      this.time = time;
   }

   public Save getSave() {
      return new Save(level, time);
   }

   public void load(Save save) {
      level = save.getLevel();
      time = save.getTime();
   }

   @Override
   public String toString() {
      return "Game{" + "level='" + level + '\'' + ", time=" + time + '}';
   }
}
