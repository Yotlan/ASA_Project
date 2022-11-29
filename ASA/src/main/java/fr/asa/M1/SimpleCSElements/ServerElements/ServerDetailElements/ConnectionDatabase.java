package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCaller;
import fr.asa.M2.ConfigurationElements.Connecteur.Connecteur_simple;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.Arrays;

public class ConnectionDatabase extends Connecteur_simple implements IConnecteur {
    public ConnectionDatabase(CDCaller caller, CDCalled called, String nameGlue, ServerDetail currentConfig) throws Exception {
        super(Arrays.asList(caller, called), nameGlue, currentConfig);
    }
}
