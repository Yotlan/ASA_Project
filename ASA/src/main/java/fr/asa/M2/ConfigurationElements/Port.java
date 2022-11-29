package fr.asa.M2.ConfigurationElements;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.Observer;

import java.util.HashSet;
import java.util.Set;

public class Port {
    public String type;
    public Configuration currentConfig;
    public IComposant currentComp;
    public Port (String type) throws Exception {
        if (type.equals("requis") || (type.equals("fournis"))) {
            this.type=type;
        }else{
            throw new Exception("Port : type error ");
        }
    }

    public String getType() {
        return type;
    }

    public void setComposant(IComposant composant) {
        this.currentComp=composant;
    }

    public void setConfig(Configuration configuration) {
        this.currentConfig=configuration;
    }

}
