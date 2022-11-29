package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Port;

public class BindingCS extends Binding {
    public BindingCS(Port portRequis, Port portFournis, SimpleCS currentConfig) throws Exception {
        super(portRequis, portFournis, currentConfig);
    }
}
