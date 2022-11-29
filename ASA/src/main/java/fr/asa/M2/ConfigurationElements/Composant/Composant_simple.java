package fr.asa.M2.ConfigurationElements.Composant;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.List;

public class Composant_simple implements IComposant {
    private List<Port> ports;
    private List<Service> services;
    public Configuration currentConfig;

    public Composant_simple(List<Port> ports, List<Service> services, Configuration currentConfig){
        this.ports=ports;
        this.services=services;
        this.currentConfig=currentConfig;
        this.currentConfig.addComposants(this);
    }

    public void addPort(Port port) {
        this.ports.add(port);
    }
    public List<Port> getPorts() {
        return ports;
    }

    public void addService(Service service) {
        this.services.add(service);
    }
    public List<Service> getServices() {
        return services;
    }
}
