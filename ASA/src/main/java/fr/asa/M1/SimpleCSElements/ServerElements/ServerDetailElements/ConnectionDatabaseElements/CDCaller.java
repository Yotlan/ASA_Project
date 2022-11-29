package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabase;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class CDCaller extends Role {


    public CDCaller(String type, ConnectionDatabase currentConnect) throws Exception {
        super(type, currentConnect);
    }
}
