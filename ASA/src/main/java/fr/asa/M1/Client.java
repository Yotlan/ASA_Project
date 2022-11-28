package fr.asa.M1;

import fr.asa.M2.Composant_simple;
import fr.asa.M2.IComposant;
import fr.asa.M2.Port;
import fr.asa.M2.Service;

import java.util.List;

public class Client extends Composant_simple implements IComposant {
    public Client(List<Port> ports, List<Service> services) {
        super(ports, services);
    }
}
