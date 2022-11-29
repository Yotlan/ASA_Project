package fr.asa.M1.SimpleCSElements.ClientElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.Client;
import fr.asa.M2.ConfigurationElements.Port;

public class SendRequest extends Port {
    public SendRequest(Client client) throws Exception {
        super("fournis",client);
    }
}
