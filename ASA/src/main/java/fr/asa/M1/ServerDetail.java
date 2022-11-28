package fr.asa.M1;

import fr.asa.M2.*;

import java.util.List;

public class ServerDetail extends Configuration {
    public ServerDetail(List<Port> ports, List<Binding> bindings, List<IComposant> IComposants, List<IConnecteur> IConnecteurs, List<Attachement> attachements) {
        super(ports, bindings, IComposants, IConnecteurs, attachements);
    }
}
