package structural.adapter.inheritance;

public class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {

   @Override
   public void drawLine() {
      drawRasterLine();
   }

   @Override
   public void drawSquare() {
      drawRasterSquare();
   }
}
