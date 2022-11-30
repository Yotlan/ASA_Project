package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManager;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurity;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabase;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManager;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Composant.Composant_complexe;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.Observable;
import fr.asa.M2.Observer;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Server extends Composant_complexe implements IComposant, Observable {
    public String name;
    public String currentMessage = "";
    public List<String> stockmsg = new ArrayList<>();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public Server(String name,ReceiveRequest ports, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(new Composant_simple(Arrays.asList(ports), new ArrayList<>(), currentConfig)), new ServerDetail());
        this.name=name;
    }

    public void notifyObservers() throws InterruptedException {
        for(IComposant composant : new HashSet<>(this.getConfig().getIComposants())) {
            if(composant instanceof Observer) {
                System.out.print(this.name+" Server spread update to ");
                ((Observer) composant).update();
            }
        }
    }

    public void setMessage(String msg) throws InterruptedException {
        System.out.println(ANSI_GREEN + msg + ANSI_RESET+"\n");
        System.out.println("Start connection to "+this.name+" Server Configuration...");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(ANSI_GREEN + "Link to "+this.name+" Server Configuration !"+ ANSI_WHITE +"\nBiding to: "+ ANSI_RESET +this.configuration.getPorts().get(0)+" of "+this.name+" Server Configuration's ports");
        for(IComposant composant : new HashSet<>(this.configuration.getIComposants())) {
            if(composant instanceof ConnectionManager) {
                for(Port port : new HashSet<>(composant.getPorts())) {
                    if(port instanceof ExternalSocket) {
                        System.out.println(ANSI_WHITE + "Biding from: "+ ANSI_RESET +port+" of Connection Manager's ports\n");
                    }
                }
                for(Attachement attachement : new HashSet<>(this.configuration.getAttachements())) {
                    if(composant.getPorts().contains(attachement.getPortRequired())){
                        System.out.println("Start connection Connection Manager RPC...");
                        TimeUnit.SECONDS.sleep(5);
                        for(IConnecteur connecteur : new HashSet<>(this.configuration.getIConnecteurs())) {
                            if(connecteur instanceof ConnectionSecurity) {
                                if(connecteur.getRoles().contains(attachement.getRoleGiven())){
                                    System.out.println(ANSI_GREEN+"Link Connection Manager to RPC !"+ANSI_RESET+"\n");
                                    if(connecteur.getRoles().contains(attachement.getRoleRequired())){
                                        System.out.println("Start connection RPC Security Manager...");
                                        TimeUnit.SECONDS.sleep(5);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        for(IComposant composant : new HashSet<>(this.configuration.getIComposants())) {
            if(composant instanceof SecurityManager) {
                for(Attachement attachement : new HashSet<>(this.configuration.getAttachements())) {
                    if(composant.getPorts().contains(attachement.getPortRequired())){
                        System.out.println(ANSI_GREEN+"Link RPC to Security Manager !"+ANSI_RESET+"\n");
                        System.out.println("Start connection Security Manager RPC...");
                        TimeUnit.SECONDS.sleep(5);
                        for(IConnecteur connecteur : new HashSet<>(this.configuration.getIConnecteurs())) {
                            if(connecteur instanceof SecurityDatabase) {
                                if(connecteur.getRoles().contains(attachement.getRoleGiven())){
                                    System.out.println(ANSI_GREEN+"Link Security Manager to RPC !"+ANSI_RESET+"\n");
                                    if(connecteur.getRoles().contains(attachement.getRoleRequired())){
                                        System.out.println("Start connection RPC Database...");
                                        TimeUnit.SECONDS.sleep(5);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        for(IComposant composant : new HashSet<>(this.configuration.getIComposants())) {
            if(composant instanceof SecurityManager) {
                for(Attachement attachement : new HashSet<>(this.configuration.getAttachements())) {
                    if(composant.getPorts().contains(attachement.getPortRequired())){
                        System.out.println(ANSI_GREEN+"Link RPC to Database !"+ANSI_RESET+"\n");
                        System.out.println("Starting transaction with Database to stock message ...");
                        TimeUnit.SECONDS.sleep(5);
                        stockmsg.add(msg);
                        System.out.println(ANSI_GREEN+"Message have successfully been stocked !"+ANSI_RESET+"\n");
                        System.out.println(ANSI_WHITE+"Database: "+ANSI_BLUE+stockmsg+ANSI_RESET+"\n");
                        break;
                    }
                }
            }
        }
        this.currentMessage=msg;
    }

    public String getUpdate(Observer observer) {
        return this.currentMessage;
    }
}
