package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.DBQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.SecurityCheck;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectionManager extends Composant_simple implements IComposant {

    public ConnectionManager(ExternalSocket port1, SecurityCheck port2, DBQuery port3, ServerDetail currentConfig) throws Exception {
        super(Arrays.asList(port1, port2, port3), new ArrayList<>(), currentConfig);
    }
}
