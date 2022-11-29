package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M2.ConfigurationElements.Port;

public class PortSD extends Port {
    public PortSD(String type, ServerDetail currentConfig) throws Exception {
        super(type, currentConfig);
    }
}
