package creational.abstractfactory.factory;

import creational.abstractfactory.aircraft.*;
import creational.abstractfactory.car.*;

public enum AbstractFactory {

   RUSSIAN_FACTORY {
      @Override
      public Aircraft createAircraft() {
         return new MC21();
      }

      @Override
      public Car createCar() {
         return new Lada();
      }
   },

   ENGLISH_FACTORY {
      @Override
      public Aircraft createAircraft() {
         return new Boeing();
      }

      @Override
      public Car createCar() {
         return new Audi();
      }
   };

   public abstract Aircraft createAircraft();
   public abstract Car createCar();
}
