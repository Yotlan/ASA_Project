package fr.asa.M1.SimpleCSElements;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Composant.Composant_complexe;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server extends Composant_complexe implements IComposant {
    public Server(ReceiveRequest ports, ServerDetail configuration, SimpleCS currentConfig) throws Exception {
        super(Arrays.asList(new Composant_simple(Arrays.asList(ports), new ArrayList<>(), currentConfig)), configuration);
    }
}
