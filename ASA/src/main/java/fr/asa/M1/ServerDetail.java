package fr.asa.M1;

import fr.asa.M2.*;
import fr.asa.M2.Composant.IComposant;
import fr.asa.M2.Port;
import fr.asa.M2.Connecteur.IConnecteur;

import java.util.List;

public class ServerDetail extends Configuration {
    public ServerDetail(List<Port> ports, List<Binding> bindings, List<IComposant> IComposants, List<IConnecteur> IConnecteurs, List<Attachement> attachements) {
        super(ports, bindings, IComposants, IConnecteurs, attachements);
    }
}
