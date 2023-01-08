package structural.hopp.protocol;

import java.rmi.RemoteException;

// Protocol interface
public interface Protocol {
   void invokeRemoteMethod() throws RemoteException;
}
