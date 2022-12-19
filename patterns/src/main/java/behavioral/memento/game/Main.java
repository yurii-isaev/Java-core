package behavioral.memento.game;

public class Main {
   public static void main(String[] args) {
      Game game = new Game();
      game.set("level_1", 300);
      System.out.println(game);

      File file = new File();
      file.setSave(game.getSave());

      game.set("level_2", 33300);
      System.out.println(game);

      System.out.println("After load:");
      game.load(file.getSave());
      System.out.println(game);

      /*
      Game{level='level_1', time=300}
      Game{level='level_2', time=33300}
      After load:
      Game{level='level_1', time=300}
      */
   }
}
