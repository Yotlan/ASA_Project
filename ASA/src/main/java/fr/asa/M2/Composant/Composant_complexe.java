package fr.asa.M2.Composant;

import fr.asa.M2.Configuration;

import java.util.List;

public class Composant_complexe implements IComposant {
    private List<IComposant> IComposants;
    private Configuration configuration;

    public Composant_complexe(List<IComposant> IComposants, Configuration configuration) {
        this.IComposants = IComposants;
        this.configuration=configuration;
    }

}