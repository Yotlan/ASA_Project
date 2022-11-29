package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCaller;
import fr.asa.M2.ConfigurationElements.Connecteur.Connecteur_simple;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.Arrays;

public class ConnectionSecurity extends Connecteur_simple implements IConnecteur {
    public ConnectionSecurity(CSCaller caller, CSCalled called, String nameGlue, ServerDetail currentConfig) throws Exception {
        super(Arrays.asList(caller, called), nameGlue, currentConfig);
    }
}
