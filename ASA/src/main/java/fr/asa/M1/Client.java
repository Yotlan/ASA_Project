package fr.asa.M1;

import fr.asa.M2.Composant.Composant_simple;
import fr.asa.M2.Composant.IComposant;
import fr.asa.M2.Port;
import fr.asa.M2.Composant.Service;

import java.util.List;

public class Client extends Composant_simple implements IComposant {
    public Client(List<Port> ports, List<Service> services) throws Exception {
        super(ports, services);
        for (Port port : ports) {
            if (port instanceof SendRequest ){
                throw new Exception("Client ports error, port are not type SendRequest");
            }
        }
    }

}
