package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Port;

public class BindingSD extends Binding {
    public BindingSD(PortSD portRequis, ExternalSocket portFournis, ServerDetail currentConfig) throws Exception {
        super(portRequis, portFournis, currentConfig);
    }
}
