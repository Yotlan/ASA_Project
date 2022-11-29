package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M1.SimpleCSElements.RPCElements.Called;
import fr.asa.M1.SimpleCSElements.RPCElements.Caller;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class AttachementCS extends Attachement {
    public AttachementCS(ReceiveRequest portRequired, SendRequest portGiven, Caller roleRequired, Called roleGiven, Configuration currentConfig) throws Exception {
        super(portRequired, portGiven, roleRequired, roleGiven, currentConfig);
    }
}
