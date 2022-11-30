package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;
import fr.asa.M2.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Client extends Composant_simple implements IComposant, Observer {
    public String name;
    public Server mainServer;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public Client(String name, SendRequest ports, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(ports), new ArrayList<>(), currentConfig);
        this.name=name;
        for(IComposant composant : this.currentConfig.getIComposants()) {
            if(composant instanceof Server) {
                this.mainServer = (Server) composant;
            }
        }
    }

    public void update() throws InterruptedException {
        String msg = mainServer.getUpdate(this);
        if (msg == null) {
            System.out.println(ANSI_WHITE + this.name + "'s thread post:"+ ANSI_RESET + "have no new message");
        } else {
            System.out.println(this.name+"\n");
            System.out.println("Refresh...\n");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(ANSI_WHITE + this.name + "'s thread post: " + ANSI_BLUE + msg + ANSI_RESET+"\n");
        }
    }

    public void post(String msg) throws InterruptedException {
        if(!this.currentConfig.getIComposants().isEmpty()
        && !this.currentConfig.getIConnecteurs().isEmpty()
        && !this.currentConfig.getAttachements().isEmpty()){
            for(Attachement attachement : new HashSet<>(this.currentConfig.getAttachements())) {
                if(this.getPorts().contains(attachement.getPortGiven())){
                    System.out.println("Start connection client RPC...");
                    TimeUnit.SECONDS.sleep(5);
                    if(this.currentConfig.getIConnecteurs().get(0).getRoles().contains(attachement.getRoleRequired())){
                        System.out.println(ANSI_GREEN+"Link client "+this.name+" to RPC !"+ANSI_RESET+"\n");
                        if(this.currentConfig.getIConnecteurs().get(0).getRoles().contains(attachement.getRoleGiven())){
                            System.out.println("Start connection RPC server...");
                            TimeUnit.SECONDS.sleep(5);
                            if(this.mainServer.getPorts().contains(attachement.getPortRequired())){
                                System.out.println(ANSI_GREEN+"Link RPC to server "+this.mainServer.name+" !"+ANSI_RESET+"\n");
                            }
                        }
                    }
                }
            }
            System.out.print(ANSI_WHITE + name+"'s post: " + ANSI_RESET);
            this.mainServer.setMessage(msg);
            this.mainServer.notifyObservers();
        } else {
            System.out.println("System Client Server is not operational !");
        }
    }

}
