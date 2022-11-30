package fr.asa.M0;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.AttachementCS;
import fr.asa.M1.SimpleCSElements.Client;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M1.SimpleCSElements.RPC;
import fr.asa.M1.SimpleCSElements.RPCElements.Called;
import fr.asa.M1.SimpleCSElements.RPCElements.Caller;
import fr.asa.M1.SimpleCSElements.Server;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.*;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.DBQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.SecurityCheck;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.QueryInterro;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.SecurityManagement;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManager;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.CheckQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.SecurityAuth;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {
        //Create ConfigCS
        SimpleCS configCS = new SimpleCS(Arrays.asList("Luffy","Big Mom","Hyogoro"),"Udon");

        Set<Client> clients = new HashSet<>();
        for(IComposant composant : configCS.getIComposants()) {
            if(composant instanceof Client) {
                clients.add((Client) composant);
            }
        }

        int nbSoup = clients.size()-1;
        for(Client client : clients) {
            if(nbSoup > 0) {
                nbSoup--;
                client.post("I eat soup ! Left "+ nbSoup +" portion !");
            } else {
                client.post("I'll kill them ! Because I have no soup left !");
            }
        }

    }
}
