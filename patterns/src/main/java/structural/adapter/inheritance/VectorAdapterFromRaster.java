package structural.adapter.inheritance;

public class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {

   @Override
   public void drawLine() {
      super.drawRasterLine();
   }

   @Override
   public void drawSquare() {
      super.drawRasterSquare();
   }
}
