package fr.asa.M1.SimpleCSElements.ServerElements;

import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.List;

public class ServerDetail extends Configuration {
    public ServerDetail(List<Port> ports, List<Binding> bindings, List<IComposant> IComposants, List<IConnecteur> IConnecteurs, List<Attachement> attachements) {
        super(ports, bindings, IComposants, IConnecteurs, attachements);
    }
}
