package structural.adapter.composition;

public class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
   public final RasterGraphics rasterGraphics;

   public VectorAdapterFromRaster(RasterGraphics rasterGraphics) {
      this.rasterGraphics = rasterGraphics;
   }

   @Override
   public void drawLine() {
      rasterGraphics.drawRasterLine();
   }

   @Override
   public void drawSquare() {
      rasterGraphics.drawRasterSquare();
   }
}
