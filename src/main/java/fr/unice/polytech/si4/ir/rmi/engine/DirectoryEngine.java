package fr.unice.polytech.si4.ir.rmi.engine;

import fr.unice.polytech.si4.ir.rmi.compute.Directory;
import fr.unice.polytech.si4.ir.rmi.data.DirectoryData;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Max on 01/12/2014.
 */
public class DirectoryEngine implements Directory {
    
    private DirectoryData data;
    private Boolean verbose;

    public DirectoryEngine(){
        super();
        data = new DirectoryData();
        verbose=true;
    }

    public String addName(String nameAndSname){

        String[] infos = nameAndSname.split(";");
        String name = infos[0];

        if(!data.containName(name)) {

            for (int i = 1; i < infos.length; i++) {
                if (data.addEntry(name, infos[i])) {
                    printInfo(name + " obtient un nouveau surnom : " + infos[i]);
                } else {
                    printInfo(infos[i] + " est déjà pris");
                }
            }
            return("ADOK");
        }else{
            printInfo("Le nom existe deja dans l'annuaire");
            return("ALRDYEX");
        }
    }

    public String getSName(String name){

        ArrayList<String> nickList;
        String s = "";

        nickList = this.data.getNick(name);
        if (nickList.size() != 0) {
            ListIterator<String> li = nickList.listIterator();

            //osPrinter(name + " est aussi appelé : ");
            printInfo(name + " est aussi appelé : ");

            while (li.hasNext()) {
                s += li.next() + ";";
            }

            printInfo(s);
            return s;


        } else {
            
            printInfo(name + " n'a pas de surnom ");
            return "NOSNAME";
        }


    }

    /**
     * Method in charge of displaying messages
     *
     * @param s
     */
    private void printInfo(String s) {

        if (verbose) {
            System.out.println("Server : " + s);
        }

    }
}
