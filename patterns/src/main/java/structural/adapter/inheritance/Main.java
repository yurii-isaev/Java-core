package structural.adapter.inheritance;

public class Main {
   public static void main(String[] args) {
      // Решение вопроса как использовать растровый рисунок имея только доступ к вектору
      // В данном случае решается вопрос взаимосвязи двух классов c помощью наследования
      VectorGraphicsInterface graphic = new VectorAdapterFromRaster();
      graphic.drawLine();
      graphic.drawSquare();

      /*
      Draw a line
      Draw a square
      */
   }
}
