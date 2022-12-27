package structural.adapter.mediaplayer;

// Adapter class 1
class VlcPlayer implements AdvancedMediaPlayer {
   @Override
   public void playVlc(String fileName) {
      System.out.println("Playing vlc file: " + fileName);
   }

   @Override
   public void playMp4(String fileName) {
      // Do nothing
   }
}
