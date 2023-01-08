package structural.hopp;

import structural.hopp.local.LocalObject;
import structural.hopp.local.LocalObjectImpl;
import structural.hopp.protocol.Protocol;
import structural.hopp.protocol.ProtocolImpl;

/**
 * Концепция Half Object plus Protocol (HOP) предназначена для управления сложностью распределенных систем.
 * Она предлагает разделение объектов на локальную и удаленную части,
 * а также определение протокола для их взаимодействия.
 * <p>
 * Вот пример реализации HOP с использованием Java RMI (Remote Method Invocation),
 * который позволяет вызывать методы удаленных объектов в Java:
 * В этом примере серверный код (Server) создает удаленный объект (RemoteObjectImpl)
 * и регистрирует его в реестре RMI.
 * Клиентский код (Client) создает локальный объект (LocalObjectImpl)
 * и объект протокола (ProtocolImpl),
 * который получает удаленную ссылку на удаленный объект и вызывает его метод через протокол.
 */

public class Client {
   public static void main(String[] args) {
      LocalObject localObject = new LocalObjectImpl();
      Protocol protocol = new ProtocolImpl();

      // Использование локального объекта
      localObject.performLocalAction();

      try {
         // Использование удаленного объекта через протокол
         protocol.invokeRemoteMethod();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
