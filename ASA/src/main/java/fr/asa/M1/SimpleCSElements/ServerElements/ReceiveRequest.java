package fr.asa.M1.SimpleCSElements.ServerElements;

import fr.asa.M1.SimpleCSElements.Server;
import fr.asa.M2.ConfigurationElements.Port;

public class ReceiveRequest extends Port {

    public ReceiveRequest(Server server) throws Exception {
        super("requis",server);

    }
}
