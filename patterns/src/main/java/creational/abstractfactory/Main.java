package creational.abstractfactory;

import creational.abstractfactory.aircraft.Aircraft;
import creational.abstractfactory.factory.AbstractFactory;

public class Main {
   public static void main(String[] args) {
      AbstractFactory factory = AbstractFactory.RUSSIAN_FACTORY;
      Aircraft aircraft = factory.createAircraft();
      aircraft.flight();
   }
}
