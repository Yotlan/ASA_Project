package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Port;

public class BindingSD extends Binding {
    public BindingSD(Port portRequis, Port portFournis) throws Exception {
        super(portRequis, portFournis);
        if ( !(portRequis instanceof PortSD)){
            throw new Exception("BindingSD error : port requis error");
        }
        if ( !(portFournis instanceof ExternalSocket)){
            throw new Exception("BindingSD error : port fournis error");
        }
    }
}
