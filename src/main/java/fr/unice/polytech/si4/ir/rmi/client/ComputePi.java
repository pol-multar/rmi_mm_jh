package fr.unice.polytech.si4.ir.rmi.client;

import fr.unice.polytech.si4.ir.rmi.compute.Compute;

import java.math.BigDecimal;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Max on 01/12/2014.
 */
public class ComputePi {
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            //Attention name doit etre le même dans le client et le serveur
            String name = "Compute";
            int port = 1099;
            Registry registry = LocateRegistry.getRegistry(port);
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(45);
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
