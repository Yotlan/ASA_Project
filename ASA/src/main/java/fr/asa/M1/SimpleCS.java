package fr.asa.M1;

import fr.asa.M1.SimpleCSElements.*;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M1.SimpleCSElements.RPCElements.Called;
import fr.asa.M1.SimpleCSElements.RPCElements.Caller;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.List;

public class SimpleCS extends Configuration {
    public SimpleCS(List<String> clients,String server) throws Exception {
        super();
        //Server
        ReceiveRequest URR = new ReceiveRequest();
        Server udon = new Server(server,URR, this);
        URR.setComposant(udon);
        URR.setConfig(this);
        this.addComposants(udon);
        //Clients
        List<SendRequest> srs = new ArrayList<>();
        for(String client : clients) {
            SendRequest SR = new SendRequest();
            Client clt = new Client(client, SR, this);
            SR.setComposant(clt);
            SR.setConfig(this);
            this.addComposants(clt);
            srs.add(SR);
        }
        //RPC
        Caller caller = new Caller();
        Called called = new Called();
        RPC rpc = new RPC(caller, called, "Client2Server",this);
        caller.setConnecteur(rpc);
        called.setConnecteur(rpc);
        this.addConnecteurs(rpc);
        //Attachements
        for(SendRequest sr : srs) {
            AttachementCS cs1 = new AttachementCS(URR, sr, caller, called, this);
            this.addAttachements(cs1);
        }
    }

}
