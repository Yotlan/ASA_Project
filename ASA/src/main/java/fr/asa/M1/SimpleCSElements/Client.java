package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;
import fr.asa.M2.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends Composant_simple implements IComposant, Observer {
    public String name;
    public Server mainServer;
    public Client(String name, SendRequest ports, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(ports), new ArrayList<>(), currentConfig);
        this.name=name;
        for(IComposant composant : this.currentConfig.getIComposants()) {
            if(composant instanceof Server) {
                this.mainServer = (Server) composant;
            }
        }
    }

    public void update() {
        String msg = mainServer.getUpdate(this);
        if (msg == null) {
            System.out.println(this.name + ": have no new message");
        } else {
            System.out.println(this.name + ": consuming message: " + msg);
        }
    }

    public void post(String msg) {
        System.out.print(name+": ");
        this.mainServer.postMessage(msg);
    }

}
