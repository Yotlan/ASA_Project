package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends Composant_simple implements IComposant {
    public Client(SendRequest ports, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(ports), new ArrayList<>(), currentConfig);
    }

}
