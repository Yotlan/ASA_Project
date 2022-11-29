package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.RPCElements.Called;
import fr.asa.M1.SimpleCSElements.RPCElements.Caller;
import fr.asa.M2.ConfigurationElements.Connecteur.Connecteur_simple;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

import java.util.Arrays;
import java.util.List;

public class RPC extends Connecteur_simple implements IConnecteur {
    public RPC(Caller caller, Called called, String nameGlue, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(caller, called), nameGlue, currentConfig);
    }
}
