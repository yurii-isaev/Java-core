package structural.adapter.mediaplayer;

// Adapter class 2
class Mp4Player implements AdvancedMediaPlayer {
   @Override
   public void playVlc(String fileName) {
      // Do nothing
   }

   @Override
   public void playMp4(String fileName) {
      System.out.println("Playing mp4 file: " + fileName);
   }
}
