package structural.proxy;

// RealSubject class
class RealImage implements Image {
   private String filename;

   public RealImage(String filename) {
      this.filename = filename;
      loadFromDisk();
   }

   private void loadFromDisk() {
      System.out.println("Loading image from disk: " + filename);
   }

   @Override
   public void display() {
      System.out.println("Displaying image: " + filename);
   }
}
