package fr.asa.M2;

import java.util.List;

public class Composant_simple implements IComposant {
    private List<Port> ports;
    private List<Service> services;

    public Composant_simple(List<Port> ports, List<Service> services){
        this.ports=ports;
        this.services=services;
    }
}
