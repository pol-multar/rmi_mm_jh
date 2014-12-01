package fr.unice.polytech.si4.ir.rmi.compute;

/**
 * Created by Max on 01/12/2014.
 *  Is the type of the parameter to the executeTask method in the Compute interface.
 *  The compute.Task interface defines the interface between the compute engine and the work that it needs to do, providing the way to start the work
 */
public interface Task<T> {
    T execute();
}
