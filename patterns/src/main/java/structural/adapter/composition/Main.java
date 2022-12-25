package structural.adapter.composition;

public class Main {
   public static void main(String[] args) {
      // Решение вопроса как использовать растровый рисунок имея только доступ к вектору
      // В данном случае решается вопрос взаимосвязи двух классов c помощью композиции
      VectorGraphicsInterface graphic = new VectorAdapterFromRaster(new RasterGraphics());
      graphic.drawLine();
      graphic.drawSquare();
   }
}
