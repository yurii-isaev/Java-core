package structural.hopp.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote part of the object
public interface RemoteObject extends Remote {

   void performRemoteAction() throws RemoteException;
}
