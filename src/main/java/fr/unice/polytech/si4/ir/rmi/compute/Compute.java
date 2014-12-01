package fr.unice.polytech.si4.ir.rmi.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Max on 01/12/2014.
 * The compute.Compute interface defines the remotely accessible part, the compute engine itself.
 * Here is the source code for the Compute interface
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
