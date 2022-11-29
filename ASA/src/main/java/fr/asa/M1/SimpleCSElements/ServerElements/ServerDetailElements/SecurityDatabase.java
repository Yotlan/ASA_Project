package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCaller;
import fr.asa.M2.ConfigurationElements.Connecteur.Connecteur_simple;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.Arrays;

public class SecurityDatabase extends Connecteur_simple implements IConnecteur {
    public SecurityDatabase(SDCaller caller, SDCalled called, String nameGlue, ServerDetail currentConfig) throws Exception {
        super(Arrays.asList(caller, called), nameGlue, currentConfig);
    }
}
