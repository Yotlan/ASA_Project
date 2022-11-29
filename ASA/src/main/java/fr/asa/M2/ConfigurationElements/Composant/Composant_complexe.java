package fr.asa.M2.ConfigurationElements.Composant;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.List;

public class Composant_complexe implements IComposant {
    private List<IComposant> IComposants;
    public Configuration configuration;

    public Composant_complexe(List<IComposant> IComposants, Configuration configuration) {
        this.IComposants = IComposants;
        this.configuration=configuration;
    }

    public List<Port> getPorts() {
        List<Port> ports = new ArrayList<>();
        for(IComposant composant : IComposants) {
            ports.addAll(composant.getPorts());
        }
        return ports;
    }

    public Configuration getConfig() {
        return this.IComposants.get(0).getConfig();
    }
}
