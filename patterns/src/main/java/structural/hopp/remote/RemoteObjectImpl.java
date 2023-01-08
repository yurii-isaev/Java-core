package structural.hopp.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote object
public class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObject {

   public RemoteObjectImpl() throws RemoteException {
      super();
   }

   @Override
   public void performRemoteAction() throws RemoteException {
      System.out.println("Performing remote action");
   }
}
