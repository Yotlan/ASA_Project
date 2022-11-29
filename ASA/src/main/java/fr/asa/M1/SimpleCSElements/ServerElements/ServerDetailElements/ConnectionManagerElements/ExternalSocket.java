package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManager;
import fr.asa.M2.ConfigurationElements.Port;

public class ExternalSocket extends Port {
    public ExternalSocket(String type, ConnectionManager currentComp) throws Exception {
        super(type, currentComp);
    }
}
