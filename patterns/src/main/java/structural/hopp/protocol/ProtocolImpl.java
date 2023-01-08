package structural.hopp.protocol;

import structural.hopp.remote.RemoteObject;

import java.rmi.Naming;
import java.rmi.RemoteException;

// Implementation of the protocol
public class ProtocolImpl implements Protocol {
   private RemoteObject remoteObject;

   public ProtocolImpl() {
      try {
         // Получение удаленной ссылки на объект
         remoteObject = (RemoteObject) Naming.lookup("rmi://localhost/RemoteObject");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public void invokeRemoteMethod() throws RemoteException {
      remoteObject.performRemoteAction();
   }
}
