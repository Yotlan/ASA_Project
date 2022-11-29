package fr.asa.M1;

import fr.asa.M1.SimpleCSElements.*;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.List;

public class SimpleCS extends Configuration {
    public SimpleCS(List<PortCS> ports, List<BindingCS> bindings, List<Client> clients, Server server, List<RPC> rpcs, List<AttachementCS> attachements) {
        super();
        for(Port port : ports) {
            addPort(port);
        }
        for(Binding binding : bindings) {
            addBinding(binding);
        }
        for(IComposant client : clients) {
            addComposants(client);
        }
        addComposants(server);
        for(IConnecteur rpc : rpcs) {
            addConnecteurs(rpc);
        }
        for(Attachement attachement : attachements) {
            addAttachements(attachement);
        }
    }

}
