package fr.asa.M2;

import java.util.List;

public class IComposant_complexe implements IComposant {
    private List<IComposant> IComposants;
    private Configuration configuration;

    public IComposant_complexe(List<IComposant> IComposants, Configuration configuration) {
        this.IComposants = IComposants;
        this.configuration=configuration;
    }

}
