package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabase;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class SDCaller extends Role {


    public SDCaller(String type, SecurityDatabase currentConnect) throws Exception {
        super(type, currentConnect);
    }
}
