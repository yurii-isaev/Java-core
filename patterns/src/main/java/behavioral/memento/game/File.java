package behavioral.memento.game;

// класс опекун
public class File {
   Save save;

   public Save getSave() {
      return save;
   }

   public void setSave(Save save) {
      this.save = save;
   }
}
