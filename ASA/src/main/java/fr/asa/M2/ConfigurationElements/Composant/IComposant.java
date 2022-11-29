package fr.asa.M2.ConfigurationElements.Composant;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.List;

public interface IComposant {
    public List<Port> getPorts();
    public Configuration getConfig();
}
