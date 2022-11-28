package fr.asa.M1;

import fr.asa.M2.Composant_complexe;
import fr.asa.M2.Configuration;
import fr.asa.M2.IComposant;

import java.util.List;

public class Server extends Composant_complexe implements IComposant {
    public Server(List<IComposant> IComposants, Configuration configuration) {
        super(IComposants, configuration);
    }
}
