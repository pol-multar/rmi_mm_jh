package fr.unice.polytech.si4.ir.rmi.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Max on 01/12/2014.
 */
public interface Directory extends Remote {

    public String addName(String nameAndSname) throws RemoteException;
    public String getSName (String name) throws RemoteException;

}
