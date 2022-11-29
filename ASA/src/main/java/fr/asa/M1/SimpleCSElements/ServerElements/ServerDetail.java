package fr.asa.M1.SimpleCSElements.ServerElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.*;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManager;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.List;

public class ServerDetail extends Configuration {
    public ServerDetail(List<PortSD> ports, List<BindingSD> bindings, ConnectionManager connectionManager, SecurityManager securityManager, Database database, ConnectionSecurity connectionSecurity, ConnectionDatabase connectionDatabase, SecurityDatabase securityDatabase, AttachementSD1 attachementSD1, AttachementSD2 attachementSD2, AttachementSD3 attachementSD3) {
        super();
        for(Port port : ports) {
            addPort(port);
        }
        for(Binding binding : bindings) {
            addBinding(binding);
        }
        addComposants(connectionManager);
        addComposants(securityManager);
        addComposants(database);
        addConnecteurs(connectionSecurity);
        addConnecteurs(connectionDatabase);
        addConnecteurs(securityDatabase);
        addAttachements(attachementSD1);
        addAttachements(attachementSD2);
        addAttachements(attachementSD3);
    }
}
