package fr.unice.polytech.si4.ir.rmi.engine;

import fr.unice.polytech.si4.ir.rmi.compute.Compute;
import fr.unice.polytech.si4.ir.rmi.compute.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Max on 01/12/2014.
 * The ComputeEngine class defines a remote object implementation class that implements a single remote interface and no other interfaces.
 * The ComputeEngine class also contains two executable program elements that can only be invoked locally.
 * The first of these elements is a constructor for ComputeEngine instances.
 * The second of these elements is a main method that is used to create a ComputeEngine instance and make it available to clients
 */
public class ComputeEngine implements Compute {

    /**
     * This constructor just invokes the superclass constructor, which is the no-argument constructor of the Object class.
     * Although the superclass constructor gets invoked even if omitted from the ComputeEngine constructor, it is included for clarity.
     */
    public ComputeEngine(){
        super();
    }

    /**
     * This method implements the protocol between the ComputeEngine remote object and its clients.
     * Each client provides the ComputeEngine with a Task object that has a particular implementation of the Task interface's execute method.
     * The ComputeEngine executes each client's task and returns the result of the task's execute method directly to the client.
     * @param t
     * @param <T>
     * @return
     */

    public <T> T executeTask(Task<T> t){
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub =
                    (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
