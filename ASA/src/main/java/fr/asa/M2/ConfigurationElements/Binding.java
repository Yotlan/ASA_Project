package fr.asa.M2.ConfigurationElements;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;

import java.util.List;

public class Binding {
    private Port portRequis;
    private Port portFournis;
    public Configuration currentConfig;

    public Binding(Port portRequis, Port portFournis, Configuration currentConfig) throws Exception {
        if (portRequis.getType().equals("requis")
                && currentConfig.getPorts().contains(portRequis)
                && portFournis.getType().equals("fournis")){
            boolean check = false;
            for(IComposant composant : currentConfig.getIComposants()) {
                if(composant.getPorts().contains(portFournis)) {
                    check = true;
                }
            }
            if(check) {
                this.portRequis = portRequis;
                this.portFournis = portFournis;
                this.currentConfig = currentConfig;
                this.currentConfig.addBinding(this);
            }else{
                throw new Exception("Binding combine error : portRequis doit etre un port requis, et portFournis doit etre un port fournis");
            }
        }else{
            throw new Exception("Binding combine error : portRequis doit etre un port requis, et portFournis doit etre un port fournis");
        }
    }
}
