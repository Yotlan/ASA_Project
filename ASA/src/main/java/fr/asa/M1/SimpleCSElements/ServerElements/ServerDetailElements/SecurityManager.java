package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.CheckQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.SecurityAuth;
import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityManager extends Composant_simple implements IComposant {
    public SecurityManager(SecurityAuth port1, CheckQuery port2, ServerDetail currentConfig) throws Exception {
        super(Arrays.asList(port1, port2), new ArrayList<>(), currentConfig);
    }
}
