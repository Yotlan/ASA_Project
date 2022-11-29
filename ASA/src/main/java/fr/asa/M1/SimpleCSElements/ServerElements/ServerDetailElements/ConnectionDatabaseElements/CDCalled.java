package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabase;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class CDCalled extends Role {


    public CDCalled(String type, ConnectionDatabase currentConnect) throws Exception {
        super(type, currentConnect);
    }
}
