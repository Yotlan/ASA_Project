package fr.asa.M1.SimpleCSElements.RPCElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.RPC;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class Called extends Role {


    public Called(RPC currentConnect) throws Exception {
        super("fournis", currentConnect);
    }
}
