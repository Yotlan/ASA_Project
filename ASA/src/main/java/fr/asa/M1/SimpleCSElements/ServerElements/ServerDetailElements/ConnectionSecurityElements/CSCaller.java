package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurity;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class CSCaller extends Role {


    public CSCaller(String type, ConnectionSecurity currentConnect) throws Exception {
        super(type, currentConnect);
    }
}
